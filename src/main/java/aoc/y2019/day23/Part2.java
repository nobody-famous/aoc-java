package aoc.y2019.day23;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
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
