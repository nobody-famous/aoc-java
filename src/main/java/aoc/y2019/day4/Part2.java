package aoc.y2019.day4;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    protected boolean isValid(int[] num) {
        var counts = new int[10];

        for (int n : num) {
            counts[n] += 1;
        }

        for (int count : counts) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }
}
