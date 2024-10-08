package aoc.y2018.day1;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var ints = parser.parse(lines);
        var total = 0;

        for (var i : ints) {
            total += i;
        }

        return total;
    }
}
