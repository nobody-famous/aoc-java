package aoc.y2019.day1;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    private final Parser parser = new Parser();
    protected List<Integer> masses;

    protected abstract int doWork();

    protected int findFuel(int mass) {
        return (mass / 3) - 2;
    }

    @Override
    public Integer solve(List<String> lines) {
        masses = parser.parse(lines);

        return doWork();
    }
}
