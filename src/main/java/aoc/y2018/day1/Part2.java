package aoc.y2018.day1;

import java.util.HashSet;
import java.util.List;

import aoc.utils.IntProblem;

public class Part2 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var values = parser.parse(lines);
        var seen = new HashSet<Integer>();

        var ndx = 0;
        var total = 0;
        var dup = 0;

        while (dup == 0) {
            total += values[ndx];

            if (seen.contains(total)) {
                dup = total;
            } else {
                seen.add(total);
                ndx = (ndx + 1) % values.length;
            }
        }

        return dup;
    }
}
