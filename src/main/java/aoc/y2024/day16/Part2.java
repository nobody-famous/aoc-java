package aoc.y2024.day16;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.utils.Grid;

public class Part2 extends Solver {
    private Set<Grid.Loc> findTiles(Grid grid, EndPoints endPoints, int targetLength) {
        return walk(grid, new HashSet<>(), endPoints.start(), EAST, endPoints.end(), 0, targetLength);
    }

    private Set<Grid.Loc> tryWalk(Grid grid, Set<Grid.Loc> seen, Grid.Loc loc, int dir, Grid.Loc end, int curLength, int targetLength) {
        var newTiles = walk(grid, seen, loc, dir, end, curLength, targetLength);

        if (!newTiles.isEmpty()) {
            newTiles.add(loc);
        }

        return newTiles;
    }

    private Set<Grid.Loc> walk(Grid grid, Set<Grid.Loc> seen, Grid.Loc loc, int dir, Grid.Loc end, int curLength, int targetLength) {
        if (loc.equals(end) && curLength == targetLength) {
            System.out.println("FOUND IT " + seen.size());
            return new HashSet<>(List.of(loc));
        } else if (grid.get(loc) != '.' || seen.contains(loc) || curLength > targetLength) {
            return new HashSet<>();
        }

        seen.add(loc);

        var tiles = new HashSet<Grid.Loc>();

        try {
            if (dir == NORTH || dir == SOUTH) {
                tiles.addAll(tryWalk(grid, seen, new Grid.Loc(loc.row(), loc.col() + 1), EAST, end, curLength + 1001, targetLength));
                tiles.addAll(tryWalk(grid, seen, new Grid.Loc(loc.row(), loc.col() - 1), WEST, end, curLength + 1001, targetLength));
            } else if (dir == EAST || dir == WEST) {
                tiles.addAll(tryWalk(grid, seen, new Grid.Loc(loc.row() - 1, loc.col()), NORTH, end, curLength + 1001, targetLength));
                tiles.addAll(tryWalk(grid, seen, new Grid.Loc(loc.row() + 1, loc.col()), SOUTH, end, curLength + 1001, targetLength));
            }

            var rowDiff = switch (dir) {
            case NORTH -> -1;
            case SOUTH -> 1;
            default -> 0;
            };

            var colDiff = switch (dir) {
            case WEST -> -1;
            case EAST -> 1;
            default -> 0;
            };

            var newLoc = new Grid.Loc(loc.row() + rowDiff, loc.col() + colDiff);

            tiles.addAll(tryWalk(grid, seen, newLoc, dir, end, curLength + 1, targetLength));
        } finally {
            seen.remove(loc);
        }

        if (!tiles.isEmpty()) {
            tiles.add(loc);
        }

        return tiles;
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var endPoints = findEndPoints(grid);

        grid.set(endPoints.start(), '.');
        grid.set(endPoints.end(), '.');

        var target = shortestDistance(grid, endPoints);
        var tiles = findTiles(grid, endPoints, target);

        return tiles.size();
    }
}
