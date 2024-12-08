package aoc.y2024.day6;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var grid = new Parser().parse(lines);

        return new Walker(grid)
                .walk()
                .size();
    }
}
