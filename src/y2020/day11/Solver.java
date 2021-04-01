package y2020.day11;

public abstract class Solver {
    private char[][] board = null;
    private char[][] nextBoard = null;
    private boolean done = false;

    abstract void updateSeat(int row, int col);

    protected Solver(char[][] board) {
        this.board = board;
    }

    protected boolean isDone() {
        return done;
    }

    protected int rowsCount() {
        return board.length;
    }

    protected int colsCount() {
        return board[0].length;
    }

    private boolean onBoard(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    protected char lookup(int row, int col) {
        return onBoard(row, col) ? board[row][col] : '\0';
    }

    protected void update(int row, int col, char ch) {
        nextBoard[row][col] = ch;
    }

    private void copyBoard() {
        nextBoard = new char[board.length][board[0].length];

        for (var row = 0; row < board.length; row += 1) {
            for (var col = 0; col < board[row].length; col += 1) {
                nextBoard[row][col] = board[row][col];
            }
        }
    }

    private boolean boardSame() {
        for (var row = 0; row < board.length; row += 1) {
            for (var col = 0; col < board[row].length; col += 1) {
                if (board[row][col] != nextBoard[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    protected long countOccupied() {
        var count = 0L;

        for (var row = 0; row < board.length; row += 1) {
            for (var col = 0; col < board[row].length; col += 1) {
                if (board[row][col] == '#') {
                    count += 1;
                }
            }
        }

        return count;
    }

    protected void printBoard() {
        for (var row = 0; row < rowsCount(); row += 1) {
            for (var col = 0; col < colsCount(); col += 1) {
                System.out.print(lookup(row, col));
            }
            System.out.println();
        }
    }

    protected void doRound() {
        copyBoard();

        for (var row = 0; row < board.length; row += 1) {
            for (var col = 0; col < board.length; col += 1) {
                updateSeat(row, col);
            }
        }

        if (boardSame()) {
            done = true;
        }

        board = nextBoard;
    }
}
