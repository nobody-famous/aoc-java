package aoc.y2019.day20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public abstract class Solver extends Problem<Integer> {
    private Parser parser = new Parser();

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    protected abstract int doWork(Maze maze, Map<Point, Map<Point, Integer>> dists);

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

    @Override
    public Integer run(List<String> lines) {
        var maze = parser.parse(lines);
        var dists = getAllDistances(maze);

        return doWork(maze, dists);
    }
}
