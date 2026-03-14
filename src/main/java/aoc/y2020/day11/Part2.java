package aoc.y2020.day11;

import java.util.List;

public class Part2 extends Solver {
    private boolean visibleOccupied(int row, int col, int dRow, int dCol) {
        while (true) {
            row += dRow;
            col += dCol;

            if (!onBoard(row, col)) {
                return false;
            }

            var ch = lookup(row, col);

            switch (ch) {
            case '#':
                return true;
            case 'L':
                return false;
            }
        }
    }

    protected int countNeighbors(int row, int col) {
        var count = 0;

        for (var dRow = -1; dRow <= 1; dRow += 1) {
            for (var dCol = -1; dCol <= 1; dCol += 1) {
                if (dRow == 0 && dCol == 0) {
                    continue;
                }

                count += visibleOccupied(row, col, dRow, dCol) ? 1 : 0;
            }
        }

        return count;
    }

    @Override
    public Integer solve(List<String> lines) {
        setBoard(new Parser().parse(lines));

        while (isNotDone()) {
            doRound(5);
        }

        return countOccupied();
    }
}
