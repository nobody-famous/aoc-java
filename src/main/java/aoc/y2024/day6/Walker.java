package aoc.y2024.day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

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
        var pt = grid.start();
        var seen = new HashMap<Direction, HashSet<Point>>();
        var hasLoop = false;
        var onGrid = true;

        initDirMap(seen);

        while (!hasLoop && onGrid) {
            hasLoop = seen.get(dir).contains(pt);

            seen.get(dir).add(pt);

            var newPoint = jumpToWall(pt);
            if (newPoint.isPresent()) {
                pt = newPoint.get();
                turnRight();
            } else {
                onGrid = false;
            }
        }

        return hasLoop;
    }

    public HashSet<Point> walk() {
        var pt = grid.start();
        var visited = new HashSet<Point>();
        var seen = new HashMap<Direction, HashSet<Point>>();
        var hasLoop = false;

        initDirMap(seen);

        while (!hasLoop && grid.map().containsKey(pt)) {
            hasLoop = seen.get(dir).contains(pt);

            seen.get(dir).add(pt);
            visited.add(pt);
            pt = step(pt);
        }

        return hasLoop ? new HashSet<>() : visited;
    }

    public HashSet<Point> getFullPath() {
        var pt = grid.start();
        var visited = new HashSet<Point>();

        while (grid.map().containsKey(pt)) {
            visited.add(pt);
            pt = step(pt);
        }

        return visited;
    }

    private Optional<Point> jumpToWall(Point pt) {
        var newPoint = switch (dir) {
        case UP -> new Point(Integer.MIN_VALUE, pt.y);
        case DOWN -> new Point(Integer.MAX_VALUE, pt.y);
        case RIGHT -> new Point(pt.x, Integer.MAX_VALUE);
        case LEFT -> new Point(pt.x, Integer.MIN_VALUE);
        };
        var found = false;

        for (var wall : grid.walls()) {
            if (dir == Direction.UP && wall.y == pt.y && wall.x < pt.x && wall.x >= newPoint.x) {
                newPoint.x = wall.x + 1;
                found = true;
            } else if (dir == Direction.DOWN && wall.y == pt.y && wall.x > pt.x && wall.x <= newPoint.x) {
                newPoint.x = wall.x - 1;
                found = true;
            } else if (dir == Direction.RIGHT && wall.x == pt.x && wall.y > pt.y && wall.y <= newPoint.y) {
                newPoint.y = wall.y - 1;
                found = true;
            } else if (dir == Direction.LEFT && wall.x == pt.x && wall.y < pt.y && wall.y >= newPoint.y) {
                newPoint.y = wall.y + 1;
                found = true;
            }
        }

        return found ? Optional.of(newPoint) : Optional.empty();
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
