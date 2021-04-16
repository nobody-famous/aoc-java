package y2020.day23;

import utils.Problem;

public abstract class Solver implements Problem {
    protected int[] input;
    protected Node[] board;
    protected int current;
    // protected int timer;
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
        var cups = new int[3];
        var cup = current;

        // var start = System.currentTimeMillis();
        for (var ndx = 0; ndx < 3; ndx += 1) {
            cup = board[cup].getNext();
            cups[ndx] = cup;
        }
        // timer += (System.currentTimeMillis() - start);

        var last = cups[2];
        board[current].setNext(board[last].getNext());

        var dest = dec(current);

        while (dest == cups[0] || dest == cups[1] || dest == cups[2]) {
            dest = dec(dest);
        }

        var tmp = board[dest].getNext();
        board[dest].setNext(cups[0]);
        board[cups[2]].setNext(tmp);

        current = board[current].getNext();
    }
}
