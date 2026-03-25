package aoc.y2024.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract int calculatePrice(List<Region> regions);

    protected record Region(int area, List<Grid.Loc> northFences, List<Grid.Loc> southFences, List<Grid.Loc> eastFences, List<Grid.Loc> westFences) {
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var regions = findRegions(grid);

        return calculatePrice(regions);
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
        var area = 0;
        var northFences = new ArrayList<Grid.Loc>();
        var southFences = new ArrayList<Grid.Loc>();
        var eastFences = new ArrayList<Grid.Loc>();
        var westFences = new ArrayList<Grid.Loc>();

        toCheck.add(start);

        while (!toCheck.isEmpty()) {
            var newToCheck = new HashSet<Grid.Loc>();

            for (var loc : toCheck) {
                area++;
                used[loc.row()][loc.col()] = true;

                var north = new Grid.Loc(loc.row() - 1, loc.col());
                if (grid.get(north) == target) {
                    if (!used[north.row()][north.col()]) {
                        newToCheck.add(north);
                    }
                } else {
                    northFences.add(loc);
                }

                var south = new Grid.Loc(loc.row() + 1, loc.col());
                if (grid.get(south) == target) {
                    if (!used[south.row()][south.col()]) {
                        newToCheck.add(south);
                    }
                } else {
                    southFences.add(loc);
                }

                var east = new Grid.Loc(loc.row(), loc.col() + 1);
                if (grid.get(east) == target) {
                    if (!used[east.row()][east.col()]) {
                        newToCheck.add(east);
                    }
                } else {
                    eastFences.add(loc);
                }

                var west = new Grid.Loc(loc.row(), loc.col() - 1);
                if (grid.get(west) == target) {
                    if (!used[west.row()][west.col()]) {
                        newToCheck.add(west);
                    }
                } else {
                    westFences.add(loc);
                }
            }

            toCheck = newToCheck;
        }

        return new Region(area, northFences, southFences, eastFences, westFences);
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
