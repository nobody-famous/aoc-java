package aoc.y2024.day6;

import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.geometry.Point;

public class Part2 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var grid = new Parser().parse(lines);
        var path = new Walker(grid).getFullPath();

        return countLoops(grid, path);
    }

    private int countLoops(Grid grid, HashSet<Point> path) {
        var loops = 0;

        for (var pt : path) {
            if (pt == grid.getStart()) {
                continue;
            }

            grid.set(pt, '#');
            if (isLoop(grid)) {
                loops += 1;
            }
            grid.set(pt, '.');
        }

        return loops;
    }

    private boolean isLoop(Grid grid) {
        return new Walker(grid).hasLoop();
    }
}
