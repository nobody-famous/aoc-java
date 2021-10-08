package y2019.day15;

import java.util.HashMap;
import java.util.Map;

import utils.geometry.Point;

public class GridMapper {
    private RepairDroid droid;

    public GridMapper(RepairDroid droid) {
        this.droid = droid;
    }

    public Map<Point, Integer> mapGrid() {
        var map = new HashMap<Point, Integer>();
        var pt = new Point(0, 0);

        map.put(pt, RepairDroid.Open);

        visit(map, pt);

        return map;
    }

    private void visit(Map<Point, Integer> map, Point pt) {
        visit(map, pt, null);
    }

    private void visit(Map<Point, Integer> map, Point pt, Integer dir) {
        try {
            tryMove(map, pt, RepairDroid.North);
            tryMove(map, pt, RepairDroid.South);
            tryMove(map, pt, RepairDroid.East);
            tryMove(map, pt, RepairDroid.West);
        } finally {
            if (dir != null) {
                droid.move(oppositeDir(dir));
            }
        }
    }

    private void tryMove(Map<Point, Integer> map, Point pt, int dir) {
        var newPt = newPoint(pt, dir);

        if (map.containsKey(newPt)) {
            return;
        }

        var result = droid.move(dir);

        map.put(newPt, result);

        if (result == RepairDroid.Open) {
            visit(map, newPt, dir);
        }
    }

    private Point newPoint(Point pt, int dir) {
        return switch (dir) {
            case RepairDroid.North -> new Point(pt.x, pt.y - 1);
            case RepairDroid.South -> new Point(pt.x, pt.y + 1);
            case RepairDroid.East -> new Point(pt.x + 1, pt.y);
            case RepairDroid.West -> new Point(pt.x - 1, pt.y);
            default -> throw new RuntimeException("Invalid direction");
        };
    }

    private int oppositeDir(int dir) {
        return switch (dir) {
            case RepairDroid.North -> RepairDroid.South;
            case RepairDroid.South -> RepairDroid.North;
            case RepairDroid.East -> RepairDroid.West;
            case RepairDroid.West -> RepairDroid.East;
            default -> throw new RuntimeException("Invalid direction");
        };
    }
}
