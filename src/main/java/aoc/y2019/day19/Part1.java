package aoc.y2019.day19;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private Drone drone;
    private int prevStart;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private int findStart(int y, int maxX) {
        var x = prevStart;

        while (x < maxX && drone.sendRequest(x, y) == Drone.STATIC) {
            x += 1;
        }

        return x;
    }

    private int scanLine(int y, int maxX) {
        var start = findStart(y, maxX);

        if (start == maxX) {
            prevStart = 0;
            return 0;
        }

        var count = 0;
        var x = start;

        while (x < maxX && drone.sendRequest(x, y) == Drone.PULLED) {
            count += 1;
            x += 1;
        }

        prevStart = start;

        return count;
    }

    private int scanArea(int maxX, int maxY) {
        var count = 0;

        prevStart = 0;

        for (var y = 0; y < maxY; y += 1) {
            count += scanLine(y, maxX);
        }

        return count;
    }

    public Integer run() {
        var prog = parser.parse();

        drone = new Drone(prog);

        return scanArea(50, 50);
    }
}
