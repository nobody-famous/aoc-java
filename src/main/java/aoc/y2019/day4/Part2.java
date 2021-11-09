package aoc.y2019.day4;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    protected boolean isValid(int[] num) {
        var counts = new int[10];

        for (var ndx = 0; ndx < num.length; ndx += 1) {
            var n = num[ndx];

            counts[n] += 1;
        }

        for (var ndx = 0; ndx < counts.length; ndx += 1) {
            if (counts[ndx] == 2) {
                return true;
            }
        }

        return false;
    }
}
