package y2020.day16;

import java.util.List;

public abstract class Solver {
    protected boolean isValid(long value, List<Field> fields) {
        for (var field : fields) {
            for (var range : field.getRanges()) {
                if (value >= range.getLow() && value <= range.getHigh()) {
                    return true;
                }
            }
        }

        return false;
    }
}
