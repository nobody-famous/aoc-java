package aoc.y2024.day10;

import java.util.HashSet;
import java.util.Set;

import aoc.utils.Grid;

public class Part1 extends Solver {
    private Set<Grid.Loc> walkPath(Grid grid, Grid.Loc start) {
        var frontier = new HashSet<Grid.Loc>();
        var seen = new HashSet<Grid.Loc>();

        seen.add(start);
        frontier.addAll(findNeighbors(grid, start, -1));

        while (!frontier.isEmpty()) {
            var newFrontier = new HashSet<Grid.Loc>();
            for (var pt : frontier) {
                seen.add(pt);
                newFrontier.addAll(findNeighbors(grid, pt, -1));
            }

            frontier = newFrontier;
        }

        return seen;
    }

    @Override
    public int run(Grid grid) {
        var trailHeads = findTrailEnds(grid, TRAIL_HEAD);
        var trailTails = findTrailEnds(grid, TRAIL_END);
        var counts = new int[grid.getRows()][grid.getCols()];

        for (var start : trailTails) {
            counts[start.row()][start.col()] += 1;

            var locs = walkPath(grid, start);
            for (var loc : locs) {
                counts[loc.row()][loc.col()] += 1;
            }
        }

        var result = 0;
        for (var head : trailHeads) {
            result += counts[head.row()][head.col()];
        }

        return result;
    }
}
