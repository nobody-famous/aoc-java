package aoc.y2024.day4;

import java.util.List;

public class Parser implements aoc.utils.Parser<Grid> {
    @Override
    public Grid parse(List<String> lines) {
        var grid = new Grid(lines.size(), lines.getFirst().length());

        for (var row = 0; row < lines.size(); row += 1) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col += 1) {
                grid.set(row, col, line.charAt(col));
            }
        }

        return grid;
    }
}
