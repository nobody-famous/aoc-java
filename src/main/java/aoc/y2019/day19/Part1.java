package aoc.y2019.day19;

public class Part1 extends Solver {
    private int prevStart;

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int scanLine(int y, int maxX) {
        var start = findStart(y, prevStart, maxX);

        if (start == maxX) {
            prevStart = 0;
            return 0;
        }

        var end = findEnd(y, start, maxX);

        prevStart = start;

        return end - start;
    }

    private int scanArea(int maxX, int maxY) {
        var count = 0;

        prevStart = 0;

        for (var y = 0; y < maxY; y += 1) {
            count += scanLine(y, maxX);
        }

        return count;
    }

    public int doWork() {
        return scanArea(50, 50);
    }
}
