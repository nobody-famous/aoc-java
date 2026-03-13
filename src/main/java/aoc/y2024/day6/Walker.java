package aoc.y2024.day6;

import java.util.HashMap;
import java.util.HashSet;

import aoc.utils.geometry.Point;

public class Walker {
    private final Grid grid;
    private Direction dir = Direction.UP;

    private enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    public Walker(Grid grid) {
        this.grid = grid;
    }

    public boolean hasLoop() {
        var pt = grid.getStart();
        var seen = new HashMap<Direction, HashSet<Point>>();

        initDirMap(seen);

        while (grid.onMap(pt)) {
            if (seen.get(dir).contains(pt)) {
                return true;
            }

            seen.get(dir).add(pt);

            pt = jumpToWall(pt);
            turnRight();
        }

        return false;
    }

    public HashSet<Point> getFullPath() {
        var pt = grid.getStart();
        var visited = new HashSet<Point>();

        while (grid.onMap(pt)) {
            visited.add(pt);
            pt = step(pt);
        }

        return visited;
    }

    private Point jumpToWall(Point pt) {
        var newPoint = new Point(pt);
        var rowDelta = switch (dir) {
        case UP -> -1;
        case DOWN -> 1;
        case RIGHT -> 0;
        case LEFT -> 0;
        };
        var colDelta = switch (dir) {
        case UP -> 0;
        case DOWN -> 0;
        case RIGHT -> 1;
        case LEFT -> -1;
        };

        while (grid.onMap(newPoint)) {
            newPoint.x += rowDelta;
            newPoint.y += colDelta;

            if (grid.get(newPoint) == '#') {
                newPoint.x -= rowDelta;
                newPoint.y -= colDelta;
                return newPoint;
            }
        }

        return new Point(-1, -1);
    }

    private void initDirMap(HashMap<Direction, HashSet<Point>> map) {
        map.put(Direction.UP, new HashSet<>());
        map.put(Direction.DOWN, new HashSet<>());
        map.put(Direction.RIGHT, new HashSet<>());
        map.put(Direction.LEFT, new HashSet<>());
    }

    private Point step(Point pt) {
        var newPoint = switch (dir) {
        case UP -> new Point(pt.x - 1, pt.y);
        case DOWN -> new Point(pt.x + 1, pt.y);
        case RIGHT -> new Point(pt.x, pt.y + 1);
        case LEFT -> new Point(pt.x, pt.y - 1);
        };

        if (grid.get(newPoint) == '#') {
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
