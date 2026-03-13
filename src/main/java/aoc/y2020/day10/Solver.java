package aoc.y2020.day10;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    protected long[] addAdapters(long[] input) {
        var adapters = new long[input.length + 2];
        var ndx = 0;
        var highest = 0L;

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
