package aoc.y2018.day1;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var ints = parser.parse();
        var total = 0;

        for (var i : ints) {
            total += i;
        }

        return total;
    }
}
