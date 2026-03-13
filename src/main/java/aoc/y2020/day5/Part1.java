package aoc.y2020.day5;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var highest = 0;

        for (var n : input) {
            if (n > highest) {
                highest = n;
            }
        }

        return highest;
    }
}
