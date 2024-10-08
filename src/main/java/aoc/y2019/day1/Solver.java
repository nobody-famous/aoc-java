package aoc.y2019.day1;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Integer> {
    private Parser parser = new Parser();
    protected List<Integer> masses;

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    protected abstract int doWork();

    protected int findFuel(int mass) {
        return (mass / 3) - 2;
    }

    @Override
    public Integer run(List<String> lines) {
        masses = parser.parse(lines);

        return doWork();
    }
}
