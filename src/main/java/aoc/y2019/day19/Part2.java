package aoc.y2019.day19;

public class Part2 extends Solver {
    private boolean squareFits(int x, int y) {
        return isBeam(x, y) && isBeam(x + 100 - 1, y - 100 + 1);
    }

    private boolean lineNoFit(int y) {
        var x = findStart(y, 0, y * y);

        return !squareFits(x, y);
    }

    private int findHigh(int start) {
        while (lineNoFit(start)) {
            start *= 10;
        }

        return start;
    }

    public int doWork() {
        var low = 100;
        var high = findHigh(low);
        var mid = high;

        while (mid != high - 1) {
            mid = low + ((high - low) / 2);

            if (lineNoFit(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        var x = findStart(high, 0, high * high);
        var y = high - 100 + 1;

        return (x * 10000) + y;
    }
}
