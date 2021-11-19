package aoc.y2019.day22;

import aoc.utils.Problem;

public class Part1 extends Problem<Long> {
    private Parser parser;

    public Part1(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Long run() {
        var shuffler = parser.parse();

        return shuffler.apply(10007, 2019);
    }
}
