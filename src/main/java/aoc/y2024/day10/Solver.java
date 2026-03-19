package aoc.y2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract int run(Grid grid);

    public static final char TRAIL_HEAD = '0';
    public static final char TRAIL_END = '9';

    protected static Set<Grid.Loc> findNeighbors(Grid grid, Grid.Loc loc, int diff) {
        var toCheck = List.of(
                new Grid.Loc(loc.row() - 1, loc.col()),
                new Grid.Loc(loc.row() + 1, loc.col()),
                new Grid.Loc(loc.row(), loc.col() - 1),
                new Grid.Loc(loc.row(), loc.col() + 1));
        var height = grid.get(loc) - '0';
        var neighbors = new HashSet<Grid.Loc>();

        for (var neighbor : toCheck) {
            if (grid.onMap(neighbor) && grid.get(neighbor) - '0' == height + diff) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    protected Set<Grid.Loc> findTrailEnds(Grid grid, char marker) {
        var ends = new HashSet<Grid.Loc>();

        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                if (grid.get(row, col) == marker) {
                    ends.add(new Grid.Loc(row, col));
                }
            }
        }

        return ends;
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);

        return run(grid);
    }
}
