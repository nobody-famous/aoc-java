package aoc.y2020.day15;

import java.util.Arrays;
import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    private int numRounds;

    protected Solver(int numRounds) {
        this.numRounds = numRounds;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = Arrays.stream(lines.get(0).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
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
