package y2020.day16;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Solver {
    public Part1(Notes input) {
        super(input);
    }

    private long sumValues(List<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }

    public long solve() {
        var invalid = new ArrayList<Long>();

        for (var ticket : input.getNearby()) {
            for (var value : ticket.getValues()) {
                if (!isValid(value, input.getFields())) {
                    invalid.add(value);
                }
            }
        }

        return sumValues(invalid);
    }
}
