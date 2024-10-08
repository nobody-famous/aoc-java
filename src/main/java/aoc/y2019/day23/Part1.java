package aoc.y2019.day23;

import java.util.List;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var prog = parser.parse(lines);
        var network = new Network(prog, 50);

        network.start();

        var pkt = network.run();

        return (int) pkt.y();
    }
}
