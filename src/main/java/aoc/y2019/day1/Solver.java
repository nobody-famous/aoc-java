package aoc.y2019.day1;

import java.util.List;

import aoc.utils.IntProblem;

public abstract class Solver extends IntProblem {
    private final Parser parser = new Parser();
    protected List<Integer> masses;

    protected abstract int doWork();

    protected int findFuel(int mass) {
        return (mass / 3) - 2;
    }

    @Override
    public int solve(List<String> lines) {
        masses = parser.parse(lines);

        return doWork();
    }
}
