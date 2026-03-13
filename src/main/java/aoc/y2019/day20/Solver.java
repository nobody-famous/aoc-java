package aoc.y2019.day20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;
import aoc.utils.geometry.Point;

public abstract class Solver implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    protected abstract int doWork(Maze maze, Map<Point, Map<Point, Integer>> distances);

    private void addPoints(Map<Point, Map<Point, Integer>> distances, Maze maze, Map<Point, String> jumps) {
        for (var pt : jumps.keySet()) {
            var mapper = new DistMapper(maze, pt);

            distances.put(pt, mapper.getDistances());
        }
    }

    private Map<Point, Map<Point, Integer>> getAllDistances(Maze maze) {
        var distances = new HashMap<Point, Map<Point, Integer>>();

        addPoints(distances, maze, maze.innerJumps);
        addPoints(distances, maze, maze.outerJumps);

        return distances;
    }

    @Override
    public Integer solve(List<String> lines) {
        var maze = parser.parse(lines);
        var distances = getAllDistances(maze);

        return doWork(maze, distances);
    }
}
