package aoc.y2020.day5;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private int[] input;

    public Part1(int[] input, long expected) {
        super(expected);
        this.input = input;
    }

    public Long run() {
        var highest = 0L;

        for (var n : input) {
            if (n > highest) {
                highest = n;
            }
        }

        return highest;
    }
}
