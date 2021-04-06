package y2020.day14;

import java.util.Collection;

import utils.Problem;

public abstract class Solver implements Problem {
    protected Op[] prog;

    protected Solver(Op[] prog) {
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
