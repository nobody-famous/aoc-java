package aoc.y2019.day23;

import java.util.List;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
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
