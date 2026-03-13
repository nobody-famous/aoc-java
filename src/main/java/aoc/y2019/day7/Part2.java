package aoc.y2019.day7;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part2 implements AocProblem<Long> {
    private final Parser parser = new Parser();

    @Override
    public Long solve(List<String> lines) {
        var prog = parser.parse(lines);
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
