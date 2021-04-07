package y2020.day1;

import utils.Problem;

public abstract class Solver implements Problem {
    protected int[] input;
    protected int target;

    protected Solver(int[] input, int target) {
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

    public long solve() {
        var entries = findCandidates(input, target);

        if (entries == null) {
            throw new RuntimeException("No solution found");
        }

        var answer = product(entries);

        return answer;
    }
}
