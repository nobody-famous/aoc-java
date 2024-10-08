package aoc.y2019.day20;

import java.util.Map;

import aoc.utils.geometry.Point;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected int doWork(Maze maze, Map<Point, Map<Point, Integer>> dists) {
        var finder = new PathFinder(maze, dists);

        return finder.shortestPath();
    }
}
