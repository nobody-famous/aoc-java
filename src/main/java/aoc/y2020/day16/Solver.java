package aoc.y2020.day16;

import java.util.List;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected Notes input;

    protected Solver(Notes input, long expected) {
        this.input = input;
    }

    protected boolean inField(long value, Field field) {
        for (var range : field.ranges()) {
            if (value >= range.low() && value <= range.high()) {
                return true;
            }
        }

        return false;
    }

    protected boolean notValid(long value, List<Field> fields) {
        for (var field : fields) {
            if (inField(value, field)) {
                return false;
            }
        }

        return true;
    }
}
