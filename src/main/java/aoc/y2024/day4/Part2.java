package aoc.y2024.day4;

import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public char getTargetChar() {
        return 'A';
    }

    @Override
    public int countMatches(Grid grid, Point pt) {
        var count = 0;

        if (matches(grid, pt.x, pt.y)) {
            count += 1;
        }

        return count;
    }

    private boolean matches(Grid grid, int row, int col) {
        return matches(grid, new Point(row - 1, col - 1), new Point(row + 1, col + 1))
                && matches(grid, new Point(row - 1, col + 1), new Point(row + 1, col - 1));
    }

    private boolean matches(Grid grid, Point p1, Point p2) {
        if (!grid.onMap(p1.x, p1.y) || !grid.onMap(p2.x, p2.y)) {
            return false;
        }

        return (grid.get(p1.x, p1.y) == 'M' && grid.get(p2.x, p2.y) == 'S')
                || (grid.get(p1.x, p1.y) == 'S' && grid.get(p2.x, p2.y) == 'M');
    }
}
