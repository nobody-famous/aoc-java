package aoc.y2020.day23;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected int[] input;
    protected int[] board;
    protected int current;
    private final int maximum;

    protected Solver(int[] input, int maximum, long expected) {
        super(expected);
        this.input = input;
        this.maximum = maximum;
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

        var destination = dec(current);

        while (destination == first || destination == second || destination == third) {
            destination = dec(destination);
        }

        var tmp = board[destination];
        board[destination] = first;
        board[third] = tmp;

        current = board[current];
    }
}
