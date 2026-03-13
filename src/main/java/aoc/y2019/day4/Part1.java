package aoc.y2019.day4;

public class Part1 extends Solver {
    protected boolean isValid(int[] num) {
        for (var ndx = 1; ndx < num.length; ndx += 1) {
            if (num[ndx] == num[ndx - 1]) {
                return true;
            }
        }

        return false;
    }
}
