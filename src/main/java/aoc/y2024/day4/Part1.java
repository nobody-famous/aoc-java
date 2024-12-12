package aoc.y2024.day4;

import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private List<Point> diffs = List.of(
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
    public Integer run(List<String> lines) {
        var grid = new Parser().parse(lines);
        var startPoints = grid.findAll('X');
        var answer = 0;

        for (var pt : startPoints) {
            answer += countMatches(grid, "XMAS", pt);
        }

        return answer;
    }

    private int countMatches(Grid grid, String target, Point pt) {
        int count = 0;

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
