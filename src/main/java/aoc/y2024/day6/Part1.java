package aoc.y2024.day6;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var grid = new Parser().parse(lines);

        return new Walker(grid).getFullPath().size();
    }
}
