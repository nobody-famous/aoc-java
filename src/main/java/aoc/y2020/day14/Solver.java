package aoc.y2020.day14;

import java.util.Collection;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    protected long sumValues(Collection<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }
}
