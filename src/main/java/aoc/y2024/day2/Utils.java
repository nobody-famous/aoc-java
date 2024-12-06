package aoc.y2024.day2;

import java.util.List;

public interface Utils {
    static boolean isSafe(List<Integer> report) {
        return isSafe(report, report.size());
    }

    static boolean isSafe(List<Integer> report, int toSkip) {
        var cur = toSkip == 0 ? 1 : 0;
        var next = cur + 1 == toSkip ? cur + 2 : cur + 1;
        var slope = 0;

        while (next < report.size()) {
            if (slope == 0) {
                slope = report.get(next) - report.get(cur);
            }

            var diff = report.get(next) - report.get(cur);
            if (!isValidStep(diff) || (slope < 0 && diff > 0) || (slope > 0 && diff < 0)) {
                return false;
            }

            cur = next;
            next = next + 1 == toSkip ? next + 2 : next + 1;
        }

        return true;
    }

    private static boolean isValidStep(int diff) {
        var absDiff = Math.abs(diff);
        return absDiff >= 1 && absDiff <= 3;
    }
}
