package aoc.y2024.day17;

import java.util.List;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Long> {
    @Override
    public Long solve(List<String> lines) {
        var config = new Parser().parse(lines);
        var computer = new ReverseComputer(config.program().reversed());
        var candidates = computer.run(config.program());

        System.out.println("CANDIDATES " + candidates);
        return candidates.stream().min((a, b) -> a > b ? 1 : -1).orElse(0L);
    }
}
