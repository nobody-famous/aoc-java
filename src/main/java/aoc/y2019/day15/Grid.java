package aoc.y2019.day15;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.geometry.Point;

public class Grid {
    private Map<Point, Integer> grid;
    private Point minPt;
    private Point maxPt;
    private Point oxygen;

    public Grid() {
        grid = new HashMap<>();
        minPt = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        maxPt = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void add(Point pt, int value) {
        updateMinMax(pt);

        grid.put(pt, value);

        if (value == RepairDroid.Oxygen) {
            oxygen = pt;
        }
    }

    public int get(Point pt) {
        return grid.containsKey(pt) ? grid.get(pt) : RepairDroid.Wall;
    }

    public Point getOxygen() {
        return oxygen;
    }

    public boolean seen(Point pt) {
        return grid.containsKey(pt);
    }

    private void updateMinMax(Point pt) {
        minPt.x = Math.min(minPt.x, pt.x);
        minPt.y = Math.min(minPt.y, pt.y);

        maxPt.x = Math.max(maxPt.x, pt.x);
        maxPt.y = Math.max(maxPt.y, pt.y);
    }

    private char cellToChar(int cell) {
        return switch (cell) {
            case RepairDroid.Open -> ' ';
            case RepairDroid.Oxygen -> 'O';
            case -1 -> '.';
            default -> '#';
        };
    }

    public String toString() {
        var str = new StringBuffer();

        for (var y = minPt.y; y <= maxPt.y; y += 1) {
            for (var x = minPt.x; x <= maxPt.x; x += 1) {
                var pt = new Point(x, y);
                var value = grid.containsKey(pt) ? grid.get(pt) : RepairDroid.Wall;
                var cell = (x == 0 && y == 0) ? 'X' : cellToChar(value);

                str.append(cell);
            }

            str.append(System.lineSeparator());
        }

        return str.toString();
    }
}
