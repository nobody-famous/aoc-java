package aoc.y2024.day6;

import java.util.HashMap;
import java.util.HashSet;

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
        var loc = grid.getStart();
        var seen = new HashMap<Direction, HashSet<Grid.Loc>>();

        initDirMap(seen);

        while (grid.onMap(loc)) {
            if (seen.get(dir).contains(loc)) {
                return true;
            }

            seen.get(dir).add(loc);

            loc = jumpToWall(loc);
            turnRight();
        }

        return false;
    }

    public HashSet<Grid.Loc> getFullPath() {
        var pt = grid.getStart();
        var visited = new HashSet<Grid.Loc>();

        while (grid.onMap(pt)) {
            visited.add(pt);
            pt = step(pt);
        }

        return visited;
    }

    private Grid.Loc jumpToWall(Grid.Loc loc) {
        var newPoint = new Grid.Loc(loc);
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
            newPoint = new Grid.Loc(newPoint.row() + rowDelta, newPoint.col() + colDelta);

            if (grid.get(newPoint) == '#') {
                return new Grid.Loc(newPoint.row() - rowDelta, newPoint.col() - colDelta);
            }
        }

        return new Grid.Loc(-1, -1);
    }

    private void initDirMap(HashMap<Direction, HashSet<Grid.Loc>> map) {
        map.put(Direction.UP, new HashSet<>());
        map.put(Direction.DOWN, new HashSet<>());
        map.put(Direction.RIGHT, new HashSet<>());
        map.put(Direction.LEFT, new HashSet<>());
    }

    private Grid.Loc step(Grid.Loc loc) {
        var newPoint = switch (dir) {
        case UP -> new Grid.Loc(loc.row() - 1, loc.col());
        case DOWN -> new Grid.Loc(loc.row() + 1, loc.col());
        case RIGHT -> new Grid.Loc(loc.row(), loc.col() + 1);
        case LEFT -> new Grid.Loc(loc.row(), loc.col() - 1);
        };

        if (grid.get(newPoint) == '#') {
            turnRight();
            return loc;
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
