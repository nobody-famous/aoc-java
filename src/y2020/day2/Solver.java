package y2020.day2;

import java.util.List;

public abstract class Solver {
    protected abstract boolean validate(DBEntry entry);

    public long run(List<DBEntry> input) {
        long numValid = 0;

        for (var entry : input) {
            if (validate(entry)) {
                numValid += 1;
            }
        }

        return numValid;
    }
}
