package aoc.y2018.day1;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var ints = parser.parse(lines);
        var seen = new HashSet<Integer>();

        var ndx = 0;
        var total = 0;
        var dup = 0;

        while (dup == 0) {
            total += ints[ndx];

            if (seen.contains(total)) {
                dup = total;
            } else {
                seen.add(total);
                ndx = (ndx + 1) % ints.length;
            }
        }

        return dup;
    }
}
