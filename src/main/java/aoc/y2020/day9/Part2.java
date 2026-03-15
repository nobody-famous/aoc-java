package aoc.y2020.day9;

import java.util.List;

import aoc.utils.LongListParser;

public class Part2 extends Solver {
    private long smallest = Long.MAX_VALUE;
    private long largest = Long.MIN_VALUE;

    private boolean hasTargetSet(long[] input, int ndx, long target) {
        var sum = 0L;

        smallest = Long.MAX_VALUE;
        largest = Long.MIN_VALUE;

        while (sum < target) {
            var value = input[ndx];

            if (value < smallest) {
                smallest = value;
            }

            if (value > largest) {
                largest = value;
            }

            sum += input[ndx];

            if (sum == target) {
                return true;
            }

            ndx += 1;
        }

        return false;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new LongListParser().parse(lines);
        var target = findWeakness(input, 25);
        var answer = 0L;

        for (var ndx = 0; ndx < input.length; ndx += 1) {
            if (hasTargetSet(input, ndx, target)) {
                answer = smallest + largest;
                break;
            }
        }

        return Math.toIntExact(answer);
    }
}
