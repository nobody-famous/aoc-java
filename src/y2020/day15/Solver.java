package y2020.day15;

import utils.Problem;

public class Solver implements Problem {
    protected int[] input;
    protected int numRounds;

    protected Solver(int[] input, int numRounds) {
        this.input = input;
        this.numRounds = numRounds;
    }

    public long solve() {
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
