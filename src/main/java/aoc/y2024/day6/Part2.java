package aoc.y2024.day6;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public class Part2 extends Problem<Integer> {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var grid = new Parser().parse(lines);
        var path = new Walker(grid).getFullPath();

        return countLoops(grid, path);
    }

    private int countLoops(Grid grid, HashSet<Point> path) {
        var loops = 0;

        for (var pt : path) {
            if (pt == grid.start()) {
                continue;
            }

            // grid.walls().add(pt);
            grid.map().put(pt, '#');
            if (isLoop(grid)) {
                loops += 1;
            }
            // grid.walls().remove(pt);
            grid.map().put(pt, '.');
        }

        return loops;
    }

    private boolean isLoop(Grid grid) {
        // return new Walker(grid).hasLoop();
        return new Walker(grid).walk().size() == 0;
    }
}
