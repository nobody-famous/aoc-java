package aoc.y2020.day11;

public class Part2 extends Solver {
    public Part2(char[][] board, long expected) {
        super(board, expected);
    }

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
    public Long run() {
        while (!isDone()) {
            doRound(5);
        }

        var answer = countOccupied();

        return answer;
    }
}
