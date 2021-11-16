package aoc.y2019.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.geometry.Point;

public class PathFinder {
    private Maze maze;
    private Map<Point, Map<Point, Integer>> dists;
    private Map<LevelPoint, Integer> toEnd = new HashMap<>();
    private LevelPoint endPoint;

    public PathFinder(Maze maze, Map<Point, Map<Point, Integer>> dists) {
        this.maze = maze;
        this.dists = dists;
    }

    private LevelPoint pointPair(LevelPoint lvlPt) {
        var pt = lvlPt.point();
        var lvl = lvlPt.level();

        if (maze.innerJumps.containsKey(pt)) {
            var name = maze.innerJumps.get(pt);
            return new LevelPoint(lvl, maze.outerJumpsByName.get(name));
        } else if (maze.outerJumps.containsKey(pt)) {
            var name = maze.outerJumps.get(pt);
            return new LevelPoint(lvl, maze.innerJumpsByName.get(name));
        }

        return null;
    }

    private int walk(LevelPoint pt, List<LevelPoint> path) {
        if (pt.equals(endPoint)) {
            return 0;
        }

        var shortest = Integer.MAX_VALUE;
        var kids = dists.get(pt.point());

        for (var kid : kids.entrySet()) {
            var kidPt = new LevelPoint(pt.level(), kid.getKey());
            var kidDist = kid.getValue();

            if (path.contains(kidPt)) {
                continue;
            }

            if (!toEnd.containsKey(kidPt)) {
                toEnd.put(kidPt, Integer.MAX_VALUE);
            }

            if (toEnd.get(kidPt) < Integer.MAX_VALUE) {
                var dist = kidDist + toEnd.get(kidPt);

                if (dist < shortest) {
                    shortest = dist;
                }

                continue;
            }

            var newPath = new ArrayList<LevelPoint>(path);
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
        var path = new ArrayList<LevelPoint>();
        var start = new LevelPoint(0, maze.outerJumpsByName.get("AA"));

        path.add(start);
        endPoint = new LevelPoint(0, maze.outerJumpsByName.get("ZZ"));

        return walk(start, path);
    }
}
