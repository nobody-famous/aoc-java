package aoc.y2019.day18;

import java.util.List;

import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<Grid> {
    private void parseLine(Grid grid, int y, String line) {
        for (var x = 0; x < line.length(); x += 1) {
            var ch = line.charAt(x);
            var pt = new Point(x, y);

            if (ch == '.') {
                grid.spaces.add(pt);
            } else if (ch == '@') {
                grid.entrances.add(pt);
                grid.spaces.add(pt);
            } else if (ch >= 'a' && ch <= 'z') {
                grid.keys.put(pt, ch);
                grid.allMasks |= grid.masks.get(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                grid.doors.put(pt, ch);
            }
        }
    }

    @Override
    public Grid parse(List<String> lines) {
        try {
            var grid = new Grid();

            for (var y = 0; y < lines.size(); y += 1) {
                parseLine(grid, y, lines.get(y));
            }

            return grid;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
