package y2020.day14;

import java.util.Collection;

public abstract class Solver {
    protected long sumValues(Collection<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }
}
