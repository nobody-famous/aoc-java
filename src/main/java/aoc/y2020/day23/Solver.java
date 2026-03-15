package aoc.y2020.day23;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    protected int[] board;
    protected int current;
    private final int maximum;

    protected Solver(int maximum) {
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
