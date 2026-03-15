package aoc.y2020.day16;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Solver {
    private long sumValues(List<Long> values) {
        var sum = 0L;

        for (var value : values) {
            sum += value;
        }

        return sum;
    }

    @Override
    public Long solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var invalid = new ArrayList<Long>();

        for (var ticket : input.nearby()) {
            for (var value : ticket.values()) {
                if (notValid(value, input.fields())) {
                    invalid.add(value);
                }
            }
        }

        return sumValues(invalid);
    }
}
