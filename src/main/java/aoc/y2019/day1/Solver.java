package aoc.y2019.day1;

import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Integer> {
    private Parser parser;
    protected List<Integer> masses;

    public Solver(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    protected abstract int doWork();

    protected int findFuel(int mass) {
        return (mass / 3) - 2;
    }

    public Integer run() {
        masses = parser.parse();

        return doWork();
    }
}
