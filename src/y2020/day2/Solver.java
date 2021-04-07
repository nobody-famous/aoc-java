package y2020.day2;

import java.util.List;

import utils.Problem;

public abstract class Solver implements Problem {
    protected List<DBEntry> input;

    public Solver(List<DBEntry> input) {
        this.input = input;
    }

    protected abstract boolean validate(DBEntry entry);

    public long solve() {
        long numValid = 0;

        for (var entry : input) {
            if (validate(entry)) {
                numValid += 1;
            }
        }

        return numValid;
    }
}
