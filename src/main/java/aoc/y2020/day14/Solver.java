package aoc.y2020.day14;

import java.util.Collection;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
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
