package y2020.day10;

import utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected int[] input;

    protected Solver(int[] input, long expected) {
        super(expected);
        this.input = input;
    }

    protected int[] addAdapters(int[] input) {
        var adapters = new int[input.length + 2];
        var ndx = 0;
        var highest = 0;

        adapters[ndx] = 0;
        ndx += 1;

        for (var item : input) {
            if (item > highest) {
                highest = item;
            }

            adapters[ndx] = item;
            ndx += 1;
        }

        adapters[ndx] = highest + 3;

        return adapters;
    }
}
