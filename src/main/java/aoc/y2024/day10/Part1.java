package aoc.y2024.day10;

import java.util.HashSet;
import java.util.Set;

import aoc.utils.Grid;
import aoc.utils.geometry.Point;

public class Part1 extends Solver {
    private Set<Point> walkPath(Grid grid, Point start) {
        var frontier = new HashSet<Point>();
        var seen = new HashSet<Point>();

        seen.add(start);
        frontier.addAll(findNeighbors(grid, start, -1));

        while (!frontier.isEmpty()) {
            var newFrontier = new HashSet<Point>();
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
            counts[start.y][start.x] += 1;

            var pts = walkPath(grid, start);
            for (var pt : pts) {
                counts[pt.y][pt.x] += 1;
            }
        }

        var result = 0;
        for (var head : trailHeads) {
            result += counts[head.y][head.x];
        }

        return result;
    }
}
