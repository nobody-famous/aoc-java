package aoc.y2024.day2;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var reports = new Parser().parse(lines);
        var answer = 0;

        for (var report : reports) {
            if (Utils.isSafe(report)) {
                answer += 1;
            }
        }

        return answer;
    }
}
