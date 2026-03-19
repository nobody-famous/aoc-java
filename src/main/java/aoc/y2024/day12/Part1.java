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

        System.out.println("REGIONS " + regions);
        throw new RuntimeException("not done yet");
    }

    private List<Region> findRegions(Grid grid) {
        var regions = new ArrayList<Region>();
        var used = new boolean[grid.getRows()][grid.getCols()];

        while (!allUsed(used)) {
            var start = findStart(grid, used);

            System.out.println("START " + start);
            used[start.row()][start.col()] = true;
        }

        return regions;
    }

    private Region findRegion(Grid grid, Grid.Loc start, boolean[][] used) {
        var target = grid.get(start);
        var toCheck = new HashSet<Grid.Loc>();

        toCheck.add(start);

        while (!toCheck.isEmpty()) {
            var newToCheck = new HashSet<Grid.Loc>();
        }

        throw new RuntimeException("not done yet");
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
