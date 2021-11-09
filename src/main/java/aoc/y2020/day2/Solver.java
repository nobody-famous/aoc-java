package aoc.y2020.day2;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected List<DBEntry> input;

    public Solver(List<DBEntry> input, long expected) {
        super(expected);
        this.input = input;
    }

    protected abstract boolean validate(DBEntry entry);

    public Long run() {
        long numValid = 0;

        for (var entry : input) {
            if (validate(entry)) {
                numValid += 1;
            }
        }

        return numValid;
    }
}
