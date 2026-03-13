package aoc.y2018.day1;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.IntListParser;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var values = new IntListParser().parse(lines);
        var total = 0;

        for (var i : values) {
            total += i;
        }

        return total;
    }
}
