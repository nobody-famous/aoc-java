package aoc.y2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.utils.AocProblem;
import aoc.utils.Grid;
import aoc.utils.geometry.Point;

public class Part1 implements AocProblem<Integer> {
    private void findTrailEnds(Grid grid, Set<Point> heads, Set<Point> tails) {
        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                if (grid.get(row, col) == '0') {
                    heads.add(new Point(row, col));
                } else if (grid.get(row, col) == '9') {
                    tails.add(new Point(row, col));
                }
            }
        }
    }

    private void addToFrontier(Set<Point> frontier, Grid grid, Point pt) {
        var neighbors = List.of(
                new Point(pt.x - 1, pt.y),
                new Point(pt.x + 1, pt.y),
                new Point(pt.x, pt.y - 1),
                new Point(pt.x, pt.y + 1));
        var height = grid.get(pt) - '0';

        for (var neighbor : neighbors) {
            if (grid.onMap(neighbor) && grid.get(neighbor) - '0' == height - 1) {
                frontier.add(neighbor);
            }
        }
    }

    private Set<Point> walkPath(Grid grid, Point start) {
        var frontier = new HashSet<Point>();
        var seen = new HashSet<Point>();

        seen.add(start);
        addToFrontier(frontier, grid, start);

        while (!frontier.isEmpty()) {
            var newFrontier = new HashSet<Point>();
            for (var pt : frontier) {
                seen.add(pt);
                addToFrontier(newFrontier, grid, pt);
            }

            frontier = newFrontier;
        }

        return seen;
    }

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var trailHeads = new HashSet<Point>();
        var trailTails = new HashSet<Point>();
        var counts = new int[grid.getRows()][grid.getCols()];

        findTrailEnds(grid, trailHeads, trailTails);

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
