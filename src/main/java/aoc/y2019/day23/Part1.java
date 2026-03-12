package aoc.y2019.day23;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public class Part1 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var network = new Network(prog, 50);

        network.start();

        var pkt = network.run();

        return (int) pkt.y();
    }
}
