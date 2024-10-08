package aoc.y2019.day22;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Long> {
    private Parser parser = new Parser();

    public Part1(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
        var shuffler = parser.parse(lines);

        return shuffler.apply(10007, 2019);
    }
}
