package aoc.y2020.day14;

import java.util.Collection;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Op[] prog;

    protected Solver(Op[] prog, long expected) {
        super(expected);
        this.prog = prog;
    }

    protected long sumValues(Collection<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }
}
