package aoc.y2024.day6;

import java.util.HashMap;
import java.util.HashSet;

import aoc.utils.geometry.Point;

public class Walker {
    private Grid grid;
    private Direction dir = Direction.UP;

    private enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    public Walker(Grid grid) {
        this.grid = grid;
    }

    public HashSet<Point> walk() {
        var pt = grid.start();
        var visited = new HashSet<Point>();
        var seen = new HashMap<Direction, HashSet<Point>>();

        seen.put(Direction.UP, new HashSet<>());
        seen.put(Direction.DOWN, new HashSet<>());
        seen.put(Direction.RIGHT, new HashSet<>());
        seen.put(Direction.LEFT, new HashSet<>());

        while (grid.map().containsKey(pt)) {
            if (seen.get(dir).contains(pt)) {
                return new HashSet<>();
            }

            seen.get(dir).add(pt);
            visited.add(pt);
            pt = step(pt);
        }

        return visited;
    }

    private Point step(Point pt) {
        var newPoint = switch (dir) {
        case UP -> new Point(pt.x - 1, pt.y);
        case DOWN -> new Point(pt.x + 1, pt.y);
        case RIGHT -> new Point(pt.x, pt.y + 1);
        case LEFT -> new Point(pt.x, pt.y - 1);
        };

        var ch = grid.map().get(newPoint);
        if (ch != null && ch == '#') {
            turnRight();
            return pt;
        }

        return newPoint;
    }

    private void turnRight() {
        dir = switch (dir) {
        case UP -> Direction.RIGHT;
        case DOWN -> Direction.LEFT;
        case LEFT -> Direction.UP;
        case RIGHT -> Direction.DOWN;
        };
    }
}
