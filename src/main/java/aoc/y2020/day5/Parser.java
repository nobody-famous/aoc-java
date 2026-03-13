package aoc.y2020.day5;

import java.util.List;

public class Parser implements aoc.utils.Parser<int[]> {
    private static int toInteger(String line) {
        var result = 0;

        for (var ch : line.toCharArray()) {
            result <<= 1;

            if (ch == 'B' || ch == 'R') {
                result++;
            }
        }

        return result;
    }

    @Override
    public int[] parse(List<String> lines) {
        return lines.stream().mapToInt(Parser::toInteger).toArray();
    }
}
