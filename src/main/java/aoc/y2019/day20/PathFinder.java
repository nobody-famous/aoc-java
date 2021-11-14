package aoc.y2019.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.geometry.Point;

public class PathFinder {
    private Maze maze;
    private Map<Point, Map<Point, Integer>> dists;
    private Map<Point, Integer> toEnd = new HashMap<>();

    public PathFinder(Maze maze, Map<Point, Map<Point, Integer>> dists) {
        this.maze = maze;
        this.dists = dists;
    }

    private Point pointPair(Point pt) {
        if (maze.innerJumps.containsKey(pt)) {
            var name = maze.innerJumps.get(pt);
            return maze.outerJumpsByName.get(name);
        } else if (maze.outerJumps.containsKey(pt)) {
            var name = maze.outerJumps.get(pt);
            return maze.innerJumpsByName.get(name);
        }

        return null;
    }

    private int walk(Point pt, List<Point> path) {
        if (pt.equals(maze.outerJumpsByName.get("ZZ"))) {
            return 0;
        }

        var shortest = Integer.MAX_VALUE;
        var kids = dists.get(pt);

        for (var kid : kids.entrySet()) {
            var kidPt = kid.getKey();
            var kidDist = kid.getValue();

            if (path.contains(kidPt)) {
                continue;
            }

            if (toEnd.get(kidPt) < Integer.MAX_VALUE) {
                var dist = kidDist + toEnd.get(kidPt);

                if (dist < shortest) {
                    shortest = dist;
                }

                continue;
            }

            var newPath = new ArrayList<Point>(path);
            newPath.add(kidPt);
            newPath.add(pointPair(kidPt));

            var distToEnd = walk(kidPt, newPath);
            var newDist = distToEnd < Integer.MAX_VALUE ? kidDist + distToEnd : distToEnd;

            if (distToEnd < toEnd.get(kidPt)) {
                toEnd.put(kidPt, distToEnd);
            }

            if (newDist < shortest) {
                shortest = newDist;
            }
        }

        return shortest;
    }

    public int shortestPath() {
        for (var pt : dists.keySet()) {
            toEnd.put(pt, Integer.MAX_VALUE);
        }

        var path = new ArrayList<Point>();
        var start = maze.outerJumpsByName.get("AA");

        path.add(start);

        return walk(start, path);
    }
}
