package aoc.y2024.day6;

import java.util.List;

import aoc.utils.geometry.Point;

public class Parser implements aoc.utils.Parser<Grid> {
    @Override
    public Grid parse(List<String> lines) {
        var grid = new Grid(lines.size(), lines.get(0).length());

        for (var row = 0; row < lines.size(); row += 1) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col += 1) {
                var ch = line.charAt(col);

                grid.set(row, col, ch);

                if (ch == '^') {
                    grid.setStart(new Point(row, col));
                }
            }
        }

        return grid;
    }
}
