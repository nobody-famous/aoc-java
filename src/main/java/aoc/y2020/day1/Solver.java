package aoc.y2020.day1;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.IntListParser;

public abstract class Solver implements AocProblem<Integer> {
    private final static int TARGET = 2020;

    protected abstract int[] findCandidates(int[] input, int target);

    protected int product(int[] entries) {
        if (entries.length == 0) {
            return 0;
        }

        var answer = 1;

        for (var entry : entries) {
            answer *= entry;
        }

        return answer;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new IntListParser().parse(lines);
        var entries = findCandidates(input, TARGET);

        if (entries == null) {
            throw new RuntimeException("No solution found");
        }

        return product(entries);
    }
}
