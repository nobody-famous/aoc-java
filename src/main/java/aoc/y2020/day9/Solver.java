package aoc.y2020.day9;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected long[] input;
    protected int preambleLength;

    protected Solver(long[] input, int preambleLength, long expected) {
        super(expected);
        this.input = input;
        this.preambleLength = preambleLength;
    }

    protected boolean findPair(long[] input, int start, int end, long target) {
        for (var first = start; first < end; first += 1) {
            for (var second = first + 1; second <= end; second += 1) {
                if (input[first] + input[second] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    protected long findWeakness(long[] input, int preambleLength) {
        for (var ndx = preambleLength; ndx < input.length; ndx += 1) {
            var target = input[ndx];
            var end = ndx - 1;
            var start = (end - preambleLength) + 1;

            if (!findPair(input, start, end, target)) {
                return input[ndx];
            }
        }

        return 0;
    }
}
