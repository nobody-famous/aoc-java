package y2020.day23;

import utils.Problem;

public abstract class Solver implements Problem {
    protected int[] input;
    protected Node[] board;
    protected int current;
    private int maximum;

    protected Solver(int[] input, int maximum) {
        this.input = input;
        this.maximum = maximum;
    }

    protected void printBoard() {
        for (var ndx = 1; ndx < board.length; ndx += 1) {
            System.out.println(ndx + " -> " + board[ndx].getNext());
        }
    }

    private int dec(int ndx) {
        ndx -= 1;

        if (ndx < 1) {
            ndx = maximum;
        }

        return ndx;
    }

    protected void pickCups() {
        var first = board[current].getNext();
        var second = board[first].getNext();
        var third = board[second].getNext();

        board[current].setNext(board[third].getNext());

        var dest = dec(current);

        while (dest == first || dest == second || dest == third) {
            dest = dec(dest);
        }

        var tmp = board[dest].getNext();
        board[dest].setNext(first);
        board[third].setNext(tmp);

        current = board[current].getNext();
    }
}
