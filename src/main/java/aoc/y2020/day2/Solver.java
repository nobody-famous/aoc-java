package aoc.y2020.day2;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract boolean validate(DBEntry entry);

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var numValid = 0;

        for (var entry : input) {
            if (validate(entry)) {
                numValid += 1;
            }
        }

        return numValid;
    }
}
