package aoc.y2018.day1;

import java.util.List;

public class Parser extends aoc.utils.Parser<int[]> {
    private int parseLine(String line) {
        var negative = line.charAt(0) == '-';
        var intStr = line.substring(1);
        var intValue = Integer.parseInt(intStr);

        return negative ? -intValue : intValue;
    }

    public int[] parse(List<String> lines) {
        try {
            var ints = new int[lines.size()];

            for (var ndx = 0; ndx < lines.size(); ndx += 1) {
                var line = lines.get(ndx);

                ints[ndx] = parseLine(line);
            }

            return ints;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }
}
