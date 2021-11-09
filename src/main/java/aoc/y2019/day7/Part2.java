package aoc.y2019.day7;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Long> {
    private Parser parser;

    public Part2(String fileName, long exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    public Long run() {
        var prog = parser.parse();
        var perms = Utils.findPerms(new int[] { 5, 6, 7, 8, 9 });

        var most = 0L;

        for (var perm : perms) {
            var circuit = new Circuit(prog, 5);

            circuit.init(perm);

            var signal = circuit.runFeedback(0);
            if (signal > most) {
                most = signal;
            }
        }

        return most;
    }
}
