package y2020.day11;

public class Part1 extends Solver {
    public Part1(char[][] board) {
        super(board);
    }

    private int countNeighbors(int row, int col) {
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

    protected void updateSeat(int row, int col) {
        var cur = lookup(row, col);
        var count = countNeighbors(row, col);

        if (cur == 'L' && count == 0) {
            update(row, col, '#');
        } else if (cur == '#' && count >= 4) {
            update(row, col, 'L');
        }
    }

    public long solve() {
        while (!isDone()) {
            doRound();
        }

        return countOccupied();
    }

    public static void main(String[] args) {
        var solver = new Part1(Input.puzzle);
        var answer = solver.solve();

        System.out.println(answer);
    }
}
