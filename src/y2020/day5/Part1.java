package y2020.day5;

import utils.Problem;

public class Part1 implements Problem {
    private int[] input;

    public Part1(int[] input) {
        this.input = input;
    }

    public long solve() {
        var highest = 0L;

        for (var n : input) {
            if (n > highest) {
                highest = n;
            }
        }

        return highest;
    }
}
