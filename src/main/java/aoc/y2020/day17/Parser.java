package aoc.y2020.day17;

import java.util.List;

public class Parser implements aoc.utils.Parser<char[][]> {
    @Override
    public char[][] parse(List<String> lines) {
        var grid = new char[lines.size()][lines.get(0).length()];

        for (var row = 0; row < lines.size(); row++) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col++) {
                grid[row][col] = line.charAt(col);
            }
        }

        return grid;
    }
}
