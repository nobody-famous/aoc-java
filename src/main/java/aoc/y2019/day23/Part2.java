package aoc.y2019.day23;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part2 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var network = new Network(prog, 50);
        var lastY = 0L;

        Long foundY = null;
        Packet natPkt = null;
        while (foundY == null) {
            var newPkt = network.run();

            if (newPkt != null) {
                natPkt = newPkt;
                continue;
            }

            assert natPkt != null;

            if (natPkt.y() == lastY) {
                foundY = lastY;
            } else {
                lastY = natPkt.y();
                network.sendNat(natPkt);
            }
        }

        return foundY.intValue();
    }
}
