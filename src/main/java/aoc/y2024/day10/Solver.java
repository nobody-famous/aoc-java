package aoc.y2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.utils.AocProblem;
import aoc.utils.Grid;
import aoc.utils.geometry.Point;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract int run(Grid grid);

    public static final char TRAIL_HEAD = '0';
    public static final char TRAIL_END = '9';

    protected static Set<Point> findNeighbors(Grid grid, Point pt, int diff) {
        var toCheck = List.of(
                new Point(pt.x - 1, pt.y),
                new Point(pt.x + 1, pt.y),
                new Point(pt.x, pt.y - 1),
                new Point(pt.x, pt.y + 1));
        var height = grid.get(pt) - '0';
        var neighbors = new HashSet<Point>();

        for (var neighbor : toCheck) {
            if (grid.onMap(neighbor) && grid.get(neighbor) - '0' == height + diff) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    protected Set<Point> findTrailEnds(Grid grid, char marker) {
        var ends = new HashSet<Point>();

        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                if (grid.get(row, col) == marker) {
                    ends.add(new Point(row, col));
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
