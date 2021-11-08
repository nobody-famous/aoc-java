package aoc.y2020.day1;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected int[] input;
    protected int target;

    protected Solver(int[] input, int target, long expected) {
        super(expected);
        this.input = input;
        this.target = target;
    }

    protected abstract int[] findCandidates(int[] input, int target);

    protected long product(int[] entries) {
        if (entries.length == 0) {
            return 0;
        }

        var answer = 1;

        for (var entry : entries) {
            answer *= entry;
        }

        return answer;
    }

    public Long run() {
        var entries = findCandidates(input, target);

        if (entries == null) {
            throw new RuntimeException("No solution found");
        }

        var answer = product(entries);

        return answer;
    }
}
