package aoc.y2024.day2;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
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
