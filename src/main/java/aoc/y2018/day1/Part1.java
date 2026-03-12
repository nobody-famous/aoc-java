package aoc.y2018.day1;

import java.util.List;

import aoc.utils.IntProblem;

public class Part1 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var values = parser.parse(lines);
        var total = 0;

        for (var i : values) {
            total += i;
        }

        return total;
    }
}
