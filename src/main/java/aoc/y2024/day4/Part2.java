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
        return ((grid.onMap(row - 1, col - 1) && grid.get(row - 1, col - 1) == 'M' && grid.onMap(row + 1, col + 1) && grid.get(row + 1, col + 1) == 'S')
                || (grid.onMap(row - 1, col - 1) && grid.get(row - 1, col - 1) == 'S' && grid.onMap(row + 1, col + 1) && grid.get(row + 1, col + 1) == 'M'))
                && ((grid.onMap(row - 1, col + 1) && grid.get(row - 1, col + 1) == 'M' && grid.onMap(row + 1, col - 1) && grid.get(row + 1, col - 1) == 'S')
                        || (grid.onMap(row - 1, col + 1) && grid.get(row - 1, col + 1) == 'S' && grid.onMap(row + 1, col - 1) && grid.get(row + 1, col - 1) == 'M'));
    }
}
