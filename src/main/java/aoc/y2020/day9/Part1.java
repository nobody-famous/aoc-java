package aoc.y2020.day9;

import java.util.List;

import aoc.utils.LongListParser;

public class Part1 extends Solver {
    @Override
    public Integer solve(List<String> lines) {
        var input = new LongListParser().parse(lines);

        return Math.toIntExact(findWeakness(input, 25));
    }
}
