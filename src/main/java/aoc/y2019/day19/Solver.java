package aoc.y2019.day19;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public abstract class Solver extends Problem<Integer> {
    private Parser parser;
    private Drone drone;

    public Solver(String fileName, int exp) {
        super(exp);
        parser = new Parser(fileName);
    }

    protected abstract int doWork();

    protected int findStart(int y, int startX, int endX) {
        return findX(y, startX, endX, Drone.STATIC);
    }

    protected int findEnd(int y, int startX, int endX) {
        return findX(y, startX, endX, Drone.PULLED);
    }

    protected int findX(int y, int startX, int endX, int target) {
        var x = startX;

        while (x < endX && drone.sendRequest(x, y) == target) {
            x += 1;
        }

        return x;
    }

    protected boolean isBeam(int x, int y) {
        return drone.sendRequest(x, y) == Drone.PULLED;
    }

    public Integer run() {
        var prog = parser.parse();

        drone = new Drone(prog);

        return doWork();
    }
}
