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
    private boolean isRecusive = false;

    public PathFinder(Maze maze, Map<Point, Map<Point, Integer>> dists) {
        this.maze = maze;
        this.dists = dists;
    }

    public void setRecursive(boolean recursive) {
        isRecusive = recursive;
    }

    private String pointName(Point pt) {
        if (maze.innerJumps.containsKey(pt)) {
            return maze.innerJumps.get(pt).toLowerCase();
        } else if (maze.outerJumps.containsKey(pt)) {
            return maze.outerJumps.get(pt);
        } else {
            return "??";
        }
    }

    private LevelPoint pointPair(LevelPoint lvlPt) {
        var pt = lvlPt.point();

        if (maze.innerJumps.containsKey(pt)) {
            var name = maze.innerJumps.get(pt);
            var lvl = isRecusive ? lvlPt.level() + 1 : lvlPt.level();
            return new LevelPoint(lvl, maze.outerJumpsByName.get(name));
        } else if (maze.outerJumps.containsKey(pt)) {
            var name = maze.outerJumps.get(pt);
            var lvl = isRecusive ? lvlPt.level() - 1 : lvlPt.level();
            return new LevelPoint(lvl, maze.innerJumpsByName.get(name));
        }

        return null;
    }

    private boolean isNestedStartOrEnd(int level, LevelPoint pt) {
        var name = maze.outerJumps.get(pt.point());

        return level > 0 && ("AA".equals(name) || "ZZ".equals(name));
    }

    private boolean isOuterJump(LevelPoint pt) {
        return maze.outerJumps.get(pt.point()) != null;
    }

    private boolean isInnerJump(LevelPoint pt) {
        return maze.innerJumps.get(pt.point()) != null;
    }

    private boolean isTopInnerJump(int level, LevelPoint pt) {
        return level == 0 && maze.innerJumps.get(pt.point()) != null;
    }

    private void printPath(List<LevelPoint> path) {
        for (var pt : path) {
            System.out.print(pointName(pt.point()) + "(" + pt.level() + ")" + ",");
        }
        System.out.println();
    }

    private int levelDiff(Point pt) {
        if (maze.innerJumps.get(pt) != null) {
            return -1;
        } else if (maze.outerJumps.get(pt) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    private int walk(LevelPoint pt, List<LevelPoint> path) {
        printPath(path);

        // System.out.println(pt.level());
        if (pt.level() > 10) {
            throw new RuntimeException("Too deep");
        }

        if (pt.equals(endPoint)) {
            throw new RuntimeException("FOUND END");
            // return 0;
        }

        var shortest = Integer.MAX_VALUE;
        var kids = dists.get(pt.point());

        for (var kid : kids.entrySet()) {
            // System.out.println(pointName(pt.point()) + " " + pointName(kid.getKey()));

            var newLevel = isRecusive ? pt.level() + levelDiff(kid.getKey()) : pt.level();
            var kidPt = new LevelPoint(newLevel, kid.getKey());
            var kidDist = kid.getValue();
            var kidPair = pointPair(kidPt);

            if ("ZZ".equals(pointName(kid.getKey()))) {
                System.out.println("  ZZ " + pt.level());
            }

            if (path.contains(kidPt)) {
                System.out.println("  PATH " + pointName(pt.point()) + " " + pointName(kidPt.point()));
                continue;
            }

            if (isRecusive && (isTopInnerJump(pt.level(), kidPt) || isNestedStartOrEnd(pt.level(), kidPt))) {
                System.out.println("  SKIP " + pointName(pt.point()) + " " + pointName(kidPt.point()));
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

            if ("ZZ".equals(maze.outerJumps.get(kidPt.point()))) {
                System.out.println("Adding ZZ to path " + newLevel);
            }

            var newPath = new ArrayList<LevelPoint>(path);
            newPath.add(kidPt);
            newPath.add(kidPair);

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
