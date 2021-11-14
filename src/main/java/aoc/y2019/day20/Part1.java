package aoc.y2019.day20;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);
        parser = new Parser(fileName);
    }

    private void addPoints(Map<Point, Map<Point, Integer>> dists, Maze maze, Map<Point, String> jumps) {
        for (var pt : jumps.keySet()) {
            var mapper = new DistMapper(maze, pt);

            dists.put(pt, mapper.getDistances());
        }
    }

    private Map<Point, Map<Point, Integer>> getAllDistances(Maze maze) {
        var dists = new HashMap<Point, Map<Point, Integer>>();

        addPoints(dists, maze, maze.innerJumps);
        addPoints(dists, maze, maze.outerJumps);

        return dists;
    }

    public Integer run() {
        var maze = parser.parse();
        var dists = getAllDistances(maze);
        var finder = new PathFinder(maze, dists);

        return finder.shortestPath();
    }
}
