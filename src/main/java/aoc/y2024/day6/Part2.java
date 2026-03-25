package aoc.y2024.day6;

import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var grid = new Parser().parse(lines);
        var path = new Walker(grid).getFullPath();

        return countLoops(grid, path);
    }

    private int countLoops(Grid grid, HashSet<Grid.Loc> path) {
        var loops = 0;

        for (var loc : path) {
            if (loc == grid.getStart()) {
                continue;
            }

            grid.set(loc, '#');
            if (isLoop(grid)) {
                loops += 1;
            }
            grid.set(loc, '.');
        }

        return loops;
    }

    private boolean isLoop(Grid grid) {
        return new Walker(grid).hasLoop();
    }
}
