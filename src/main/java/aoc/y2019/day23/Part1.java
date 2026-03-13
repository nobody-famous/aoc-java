package aoc.y2019.day23;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part1 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var network = new Network(prog, 50);

        network.start();

        var pkt = network.run();

        return (int) pkt.y();
    }
}
