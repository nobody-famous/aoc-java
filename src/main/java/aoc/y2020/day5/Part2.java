package aoc.y2020.day5;

import java.util.List;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var min = Long.MAX_VALUE;
        var max = Long.MIN_VALUE;
        var sum = 0;

        for (var n : input) {
            if (n < min) {
                min = n;
            }

            if (n > max) {
                max = n;
            }

            sum += n;
        }

        var rangeSum = 0;
        for (var i = min; i <= max; i += 1) {
            rangeSum += (int) i;
        }

        return rangeSum - sum;
    }
}
