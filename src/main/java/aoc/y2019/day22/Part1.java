package aoc.y2019.day22;

import java.util.List;

import aoc.utils.LongProblem;

public class Part1 extends LongProblem {
    private final Parser parser = new Parser();

    @Override
    public long solve(List<String> lines) {
        var shuffler = parser.parse(lines);

        return shuffler.apply(10007, 2019);
    }
}
