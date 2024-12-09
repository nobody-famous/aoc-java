package aoc.y2024.day6;

import java.util.List;

import aoc.utils.geometry.Point;

public class Parser implements aoc.utils.Parser<Grid> {
    @Override
    public Grid parse(List<String> lines) {
        var items = new char[lines.size()][lines.get(0).length()];
        var start = new Point(0, 0);

        for (var row = 0; row < lines.size(); row += 1) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col += 1) {
                var ch = line.charAt(col);

                items[row][col] = ch;

                if (ch == '^') {
                    start = new Point(row, col);
                }
            }
        }

        return new Grid(items, start);
    }
}
