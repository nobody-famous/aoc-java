package aoc.y2020.day11;

import java.util.List;

public class Part1 extends Solver {
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
    public Integer solve(List<String> lines) {
        setBoard(new Parser().parse(lines));

        while (isNotDone()) {
            doRound(4);
        }

        return countOccupied();
    }
}
