package aoc.y2019.day20;

import java.util.Map;

import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    @Override
    protected int doWork(Maze maze, Map<Point, Map<Point, Integer>> distances) {
        var finder = new PathFinder(maze, distances);

        finder.setRecursive(true);

        return finder.shortestPath();
    }
}
