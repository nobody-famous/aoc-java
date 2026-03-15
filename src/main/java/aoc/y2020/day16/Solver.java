package aoc.y2020.day16;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
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
