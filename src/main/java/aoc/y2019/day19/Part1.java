package aoc.y2019.day19;

public class Part1 extends Solver {
    private int prevStart;
    private final static int MAX_X = 50;
    private final static int MAX_Y = 50;

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int scanLine(int y) {
        var maxX = MAX_X;
        var start = findStart(y, prevStart, maxX);

        if (start == maxX) {
            prevStart = 0;
            return 0;
        }

        var end = findEnd(y, start, maxX);

        prevStart = start;

        return end - start;
    }

    private int scanArea() {
        var count = 0;

        prevStart = 0;

        for (var y = 0; y < MAX_Y; y += 1) {
            count += scanLine(y);
        }

        return count;
    }

    public int doWork() {
        return scanArea();
    }
}
