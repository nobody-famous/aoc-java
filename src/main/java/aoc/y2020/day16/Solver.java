package aoc.y2020.day16;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Notes input;

    protected Solver(Notes input, long expected) {
        super(expected);
        this.input = input;
    }

    protected boolean inField(long value, Field field) {
        for (var range : field.getRanges()) {
            if (value >= range.getLow() && value <= range.getHigh()) {
                return true;
            }
        }

        return false;
    }

    protected boolean isValid(long value, List<Field> fields) {
        for (var field : fields) {
            if (inField(value, field)) {
                return true;
            }
        }

        return false;
    }
}
