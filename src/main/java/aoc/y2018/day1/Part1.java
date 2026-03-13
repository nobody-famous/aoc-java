package aoc.y2018.day1;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var values = parser.parse(lines);
        var total = 0;

        for (var i : values) {
            total += i;
        }

        return total;
    }
}
