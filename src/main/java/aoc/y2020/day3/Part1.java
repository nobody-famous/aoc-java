package aoc.y2020.day3;

import java.util.List;

public class Part1 extends Solver {
    @Override
    public Long solve(List<String> lines) {
        var input = parseLines(lines);
        return countTrees(input, 3, 1);
    }
}
