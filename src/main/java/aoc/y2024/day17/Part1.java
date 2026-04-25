package aoc.y2024.day17;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<String> {
    @Override
    public String solve(List<String> lines) {
        var config = new Parser().parse(lines);

        return Utils.getOutput(config.registerA(), config.program());
    }
}
