package aoc.y2024.day2;

import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var reports = new Parser().parse(lines);
        var answer = 0;

        for (var report : reports) {
            if (testReport(report)) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean testReport(List<Integer> report) {
        for (var toSkip = 0; toSkip <= report.size(); toSkip += 1) {
            if (Utils.isSafe(report, toSkip)) {
                return true;
            }
        }

        return false;
    }
}
