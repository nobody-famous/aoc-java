package aoc.y2024.day4;

import java.util.List;

import aoc.utils.geometry.Point;

public class Part1 extends Solver {
    private static List<Point> diffs = List.of(
            new Point(0, 1),
            new Point(0, -1),
            new Point(1, 1),
            new Point(1, 0),
            new Point(1, -1),
            new Point(-1, -1),
            new Point(-1, 0),
            new Point(-1, 1));

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    char getTargetChar() {
        return 'X';
    }

    @Override
    int countMatches(Grid grid, Point pt) {
        var target = "XMAS";
        var count = 0;

        for (var diff : diffs) {
            if (matches(grid, target, pt, diff)) {
                count += 1;
            }
        }

        return count;
    }

    private boolean matches(Grid grid, String target, Point start, Point diff) {
        var row = start.x;
        var col = start.y;

        for (var index = 0; index < target.length(); index += 1) {
            if (!grid.onMap(row, col) || grid.get(row, col) != target.charAt(index)) {
                return false;
            }

            row += diff.x;
            col += diff.y;
        }

        return true;
    }
}
