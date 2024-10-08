package aoc.y2020.day23;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected int[] input;
    protected int[] board;
    protected int current;
    private int maximum;

    protected Solver(int[] input, int maximum, long expected) {
        super(expected);
        this.input = input;
        this.maximum = maximum;
    }

    protected void printBoard() {
        for (var ndx = 1; ndx < board.length; ndx += 1) {
            System.out.println(ndx + " -> " + board[ndx]);
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
        var first = board[current];
        var second = board[first];
        var third = board[second];

        board[current] = board[third];

        var dest = dec(current);

        while (dest == first || dest == second || dest == third) {
            dest = dec(dest);
        }

        var tmp = board[dest];
        board[dest] = first;
        board[third] = tmp;

        current = board[current];
    }
}
