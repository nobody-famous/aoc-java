package aoc.y2019.day20;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aoc.utils.geometry.Point;

public class PathFinder {
    private Maze maze;
    private Map<Point, Map<Point, Integer>> dists;
    private boolean isRecusive = false;
    private Set<Walker> toVisit = new HashSet<>();
    private Set<LevelPoint> seen = new HashSet<>();
    private boolean foundEnd = false;
    private LevelPoint endPoint;

    private class Walker {
        public int dist;
        public LevelPoint pt;

        public Walker(int dist, LevelPoint pt) {
            this.dist = dist;
            this.pt = pt;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Walker)) {
                return false;
            }

            var them = (Walker) obj;
            return them.dist == dist && them.pt.equals(pt);
        }

        @Override
        public String toString() {
            return "{" + pointName(pt.point()) + "(" + pt.level() + ") " + dist + "}";
        }
    }

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

    private boolean isNestedStartOrEnd(int level, Point pt) {
        var name = maze.outerJumps.get(pt);

        return level > 0 && ("AA".equals(name) || "ZZ".equals(name));
    }

    private boolean isTopOuterJump(int level, Point pt) {
        var name = maze.outerJumps.get(pt);

        return level == 0 && name != null && !"AA".equals(name) && !"ZZ".equals(name);
    }

    private int levelDiff(Point pt) {
        if (maze.innerJumps.get(pt) != null) {
            return 1;
        } else if (maze.outerJumps.get(pt) != null) {
            return -1;
        } else {
            return 0;
        }
    }

    private boolean shouldSkip(int level, Point pt) {
        return isTopOuterJump(level, pt) || isNestedStartOrEnd(level, pt);
    }

    private Set<Walker> visit(Walker walker) {
        var neighbors = new HashSet<Walker>();
        var kids = dists.get(walker.pt.point());

        seen.add(walker.pt);

        for (var kid : kids.entrySet()) {
            if (isRecusive && kid.getValue() != 1 && shouldSkip(walker.pt.level(), kid.getKey())) {
                continue;
            }

            var lvlDiff = isRecusive && kid.getValue() == 1 ? levelDiff(walker.pt.point()) : 0;
            var newPoint = new LevelPoint(walker.pt.level() + lvlDiff, kid.getKey());
            var newDist = walker.dist + kid.getValue();

            if (!seen.contains(newPoint)) {
                neighbors.add(new Walker(newDist, newPoint));
            }
        }

        return neighbors;
    }

    private Integer visitAll() {
        var nextRound = new HashSet<Walker>();
        Integer shortest = null;

        for (var walker : toVisit) {
            var neighbors = visit(walker);

            for (var n : neighbors) {
                if (n.pt.equals(endPoint) && (shortest == null || n.dist < shortest)) {
                    shortest = n.dist;
                }
            }

            if (foundEnd) {
                break;
            }

            nextRound.addAll(neighbors);
        }

        toVisit = nextRound;

        return shortest;
    }

    public int shortestPath() {
        var start = new LevelPoint(0, maze.outerJumpsByName.get("AA"));

        endPoint = new LevelPoint(0, maze.outerJumpsByName.get("ZZ"));
        toVisit.add(new Walker(0, start));

        Integer dist = null;
        while (dist == null) {
            dist = visitAll();
            if (foundEnd) {
                break;
            }
        }

        return dist;
    }
}
