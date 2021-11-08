package aoc.y2019.day18;

import java.util.List;

import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<Grid> {
    public Parser(String fileName) {
        super(fileName);
    }

    private void addCell(Grid grid, Point pt, char cell) {
        if (cell == '#') {
            return;
        }

        grid.addToPath(pt);

        if (cell >= 'a' && cell <= 'z') {
            grid.addKey(pt, cell);
        } else if (cell >= 'A' && cell <= 'Z') {
            grid.addDoor(pt, cell);
        } else if (cell == '@') {
            grid.addEntrance(pt);
        }
    }

    private Grid parseGrid(List<String> lines) {
        var grid = new Grid();

        for (var y = 0; y < lines.size(); y += 1) {
            var line = lines.get(y);

            for (var x = 0; x < line.length(); x += 1) {
                addCell(grid, new Point(x, y), line.charAt(x));
            }
        }

        return grid;
    }

    public Grid parse() {
        try {
            var lines = readLines();

            return parseGrid(lines);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
