package aoc.y2020.day11;

public class Part1 extends Solver {
    public Part1(char[][] board, long expected) {
        super(board, expected);
    }

    protected int countNeighbors(int row, int col) {
        int count = 0;

        for (var nRow = row - 1; nRow <= row + 1; nRow += 1) {
            for (var nCol = col - 1; nCol <= col + 1; nCol += 1) {
                if (nRow == row && nCol == col) {
                    continue;
                }

                if (lookup(nRow, nCol) == '#') {
                    count += 1;
                }
            }
        }

        return count;
    }

    @Override
    public Long run() {
        while (!isDone()) {
            doRound(4);
        }

        var answer = countOccupied();

        return answer;
    }
}
