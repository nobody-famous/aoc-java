package aoc.y2024.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Long> {
    @Override
    public Long solve(List<String> lines) {
        var config = new Parser().parse(lines);
        var progString = config.program()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        var candidates = new ArrayList<Long>();
        var frontier = new ArrayList<Long>(List.of(0L));
        var toMatch = "";

        for (var nextOutput : config.program().reversed()) {
            toMatch = toMatch == ""
                    ? "" + nextOutput
                    : nextOutput + "," + toMatch;

            var nextFronter = new ArrayList<Long>();

            for (var item : frontier) {
                for (var add = 0; add < 8; add++) {
                    var value = item + add;
                    var output = Utils.getOutput(value, config.program());

                    if (output.equals(progString)) {
                        candidates.add(value);
                    } else if (output.equals(toMatch)) {
                        nextFronter.add(value * 8);
                    }
                }
            }

            frontier = nextFronter;
        }

        return candidates.stream().min((a, b) -> a > b ? 1 : -1).orElse(0L);
    }
}
