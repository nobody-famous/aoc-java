package aoc.y2019.day20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aoc.utils.geometry.Point;

public class DistMapper {
    private final Maze maze;
    private final Point start;
    private int curDist = 0;
    private final Map<Point, Integer> distances = new HashMap<>();
    private final Set<Point> seen = new HashSet<>();

    public DistMapper(Maze maze, Point start) {
        this.maze = maze;
        this.start = start;
    }

    private void checkPoint(Set<Point> neighbors, Point pt) {
        if (seen.contains(pt)) {
            return;
        }

        seen.add(pt);

        if (maze.outerJumps.containsKey(pt) || maze.innerJumps.containsKey(pt)) {
            distances.put(pt, curDist);
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

        if (maze.innerJumps.containsKey(start)) {
            var name = maze.innerJumps.get(start);
            distances.put(maze.outerJumpsByName.get(name), 1);
        } else if (maze.outerJumps.containsKey(start)) {
            var name = maze.outerJumps.get(start);
            var inner = maze.innerJumpsByName.get(name);

            if (inner != null) {
                distances.put(inner, 1);
            }
        }

        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            curDist += 1;
            toVisit = visitAll(toVisit);
        }

        return distances;
    }
}
