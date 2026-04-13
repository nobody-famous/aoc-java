package aoc.y2024.day16;

import java.util.List;

import aoc.utils.Grid;

public class Part1 extends Solver {
    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var endPoints = findEndPoints(grid);

        grid.set(endPoints.start(), '.');
        grid.set(endPoints.end(), '.');

        return shortestDistance(grid, endPoints);
    }
}
