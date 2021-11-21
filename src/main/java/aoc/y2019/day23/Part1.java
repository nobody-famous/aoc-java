package aoc.y2019.day23;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
        var network = new Network(prog, 50);

        var pkt = network.run();

        return (int) pkt.y();
    }
}
