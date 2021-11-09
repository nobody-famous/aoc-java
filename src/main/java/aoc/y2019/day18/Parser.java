package aoc.y2019.day18;

import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<Grid> {
    public Parser(String fileName) {
        super(fileName);
    }

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

    public Grid parse() {
        try {
            var lines = readLines();
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
