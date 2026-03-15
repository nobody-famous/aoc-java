package aoc.y2020.day13;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Long> {
    @Override
    public Long solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var min = Long.MAX_VALUE;
        var busID = 0L;

        for (var id : input.ids()) {
            if (id == null) {
                continue;
            }

            var diff = id - (input.timestamp() % id);

            if (diff < min) {
                min = diff;
                busID = id;
            }
        }

        return busID * min;
    }
}
