package aoc.y2024.day17;

import java.util.List;
import java.util.stream.Collectors;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Long> {
    @Override
    public Long solve(List<String> lines) {
        var config = new Parser().parse(lines);
        var target = config.program().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("CHECKING " + Integer.toBinaryString(0xABC) + " " + Integer.toBinaryString(0xABC % 8));

        return 0L;
    }
}
