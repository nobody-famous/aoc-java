package aoc.y2019.day20;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);
        parser = new Parser(fileName);
    }

    public Integer run() {
        var grid = parser.parse();

        System.out.println(grid);
        return 0;
    }
}
