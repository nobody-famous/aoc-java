package aoc.y2024.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<String> {
    @Override
    public String solve(List<String> lines) {
        var config = new Parser().parse(lines);
        var output = new ArrayList<Integer>();
        var computer = new Computer((value) -> output.add(value));

        computer.init(config.registerA(), config.registerB(), config.registerC());
        computer.run(config.program());

        return output.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
