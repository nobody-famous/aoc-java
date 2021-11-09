package aoc.y2020.day15;

import aoc.utils.Problem;

public class Solver extends Problem<Integer> {
    protected int[] input;
    protected int numRounds;

    protected Solver(int[] input, int numRounds, int expected) {
        super(expected);
        this.input = input;
        this.numRounds = numRounds;
    }

    public Integer run() {
        var seen = new int[numRounds];
        var turn = 1;

        for (var item : input) {
            seen[item] = turn;
            turn += 1;
        }

        var current = 0;
        while (turn < numRounds) {
            var firstTime = seen[current] == 0;
            var next = firstTime ? 0 : turn - seen[current];

            seen[current] = turn;
            current = next;

            turn += 1;
        }

        return current;
    }
}
