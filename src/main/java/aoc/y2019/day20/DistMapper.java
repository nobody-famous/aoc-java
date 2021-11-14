package aoc.y2019.day20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aoc.utils.geometry.Point;

public class DistMapper {
    private Maze maze;
    private Point start;
    private int curDist = 0;
    private Map<Point, Integer> dists = new HashMap<>();
    private Set<Point> seen = new HashSet<>();

    public DistMapper(Maze maze, Point start) {
        this.maze = maze;
        this.start = start;
    }

    private void checkPoint(Set<Point> neighbors, Point pt) {
        if (seen.contains(pt)) {
            return;
        }

        seen.add(pt);

        if (maze.outerJumps.containsKey(pt)) {
            var name = maze.outerJumps.get(pt);
            var target = maze.innerJumpsByName.get(name);

            if (target == null) {
                dists.put(pt, curDist);
            } else {
                dists.put(target, curDist + 1);
            }
        } else if (maze.innerJumps.containsKey(pt)) {
            var name = maze.innerJumps.get(pt);
            var target = maze.outerJumpsByName.get(name);

            dists.put(target, curDist + 1);
        } else if (maze.path.contains(pt)) {
            neighbors.add(pt);
        }
    }

    private Set<Point> visit(Point pt) {
        var neighbors = new HashSet<Point>();

        checkPoint(neighbors, new Point(pt.x, pt.y - 1));
        checkPoint(neighbors, new Point(pt.x, pt.y + 1));
        checkPoint(neighbors, new Point(pt.x - 1, pt.y));
        checkPoint(neighbors, new Point(pt.x + 1, pt.y));

        return neighbors;
    }

    private Set<Point> visitAll(Set<Point> toVisit) {
        var nextSet = new HashSet<Point>();

        for (var pt : toVisit) {
            var neighbors = visit(pt);

            nextSet.addAll(neighbors);
        }

        return nextSet;
    }

    public Map<Point, Integer> getDistances() {
        Set<Point> toVisit = new HashSet<>();

        seen.add(start);
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            curDist += 1;
            toVisit = visitAll(toVisit);
        }

        return dists;
    }
}
