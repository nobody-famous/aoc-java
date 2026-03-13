package aoc.y2024.day6;

import java.util.List;

import aoc.utils.IntProblem;

public class Part1 extends IntProblem {
    @Override
    public int solve(List<String> lines) {
        var grid = new Parser().parse(lines);

        return new Walker(grid).getFullPath().size();
    }
}
