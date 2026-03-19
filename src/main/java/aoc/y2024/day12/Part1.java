package aoc.y2024.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public class Part1 implements AocProblem<Integer> {
    private record Region(int area, int fences) {
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var regions = findRegions(grid);

        return regions.stream().map(r -> r.area * r.fences).mapToInt(Integer::intValue).sum();
    }

    private List<Region> findRegions(Grid grid) {
        var regions = new ArrayList<Region>();
        var used = new boolean[grid.getRows()][grid.getCols()];

        while (!allUsed(used)) {
            var start = findStart(grid, used);

            regions.add(findRegion(grid, start, used));
        }

        return regions;
    }

    private Region findRegion(Grid grid, Grid.Loc start, boolean[][] used) {
        var target = grid.get(start);
        var toCheck = new HashSet<Grid.Loc>();
        var diffs = List.of(
                new Grid.Loc(-1, 0),
                new Grid.Loc(1, 0),
                new Grid.Loc(0, -1),
                new Grid.Loc(0, 1));
        var area = 0;
        var fences = 0;

        toCheck.add(start);

        while (!toCheck.isEmpty()) {
            var newToCheck = new HashSet<Grid.Loc>();

            for (var loc : toCheck) {
                area++;
                used[loc.row()][loc.col()] = true;

                var neighbors = diffs.stream().map(diff -> new Grid.Loc(loc.row() + diff.row(), loc.col() + diff.col())).toList();

                for (var neighbor : neighbors) {
                    if (grid.onMap(neighbor) && grid.get(neighbor) == target && used[neighbor.row()][neighbor.col()]) {
                        continue;
                    }

                    if (grid.get(neighbor) == target) {
                        newToCheck.add(neighbor);
                    } else {
                        fences++;
                    }
                }
            }

            toCheck = newToCheck;
        }

        return new Region(area, fences);
    }

    private boolean allUsed(boolean[][] used) {
        for (var row = 0; row < used.length; row++) {
            for (var col = 0; col < used[row].length; col++) {
                if (!used[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private Grid.Loc findStart(Grid grid, boolean[][] used) {
        for (var row = 0; row < used.length; row++) {
            for (var col = 0; col < used[row].length; col++) {
                if (!used[row][col]) {
                    return new Grid.Loc(row, col);
                }
            }
        }

        throw new RuntimeException("did not find starting point");
    }
}
