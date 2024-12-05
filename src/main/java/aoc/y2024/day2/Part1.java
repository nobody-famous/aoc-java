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
            if (isSafe(report)) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isSafe(List<Integer> report) {
        var slope = 0;

        for (int cur = 0, next = 1; next < report.size(); cur = next, next += 1) {
            if (slope == 0) {
                slope = report.get(next) - report.get(cur);
            }

            var diff = report.get(next) - report.get(cur);
            if (diff == 0 || (slope < 0 && diff > 0) || (slope > 0 && diff < 0) || !isValidStep(diff)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidStep(int diff) {
        var absDiff = Math.abs(diff);
        return absDiff >= 1 && absDiff <= 3;
    }
}
