package aoc.y2019.day22;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Long> {
    private final Parser parser = new Parser();

    @Override
    public Long solve(List<String> lines) {
        var shuffler = parser.parse(lines);

        return shuffler.apply(10007, 2019);
    }
}
