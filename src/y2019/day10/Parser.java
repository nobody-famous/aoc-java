package y2019.day10;

import java.util.ArrayList;
import java.util.List;

import utils.geometry.Point;

public class Parser extends utils.Parser<List<Point>> {
    public Parser(String fileName) {
        super(fileName);
    }

    private List<Point> parseMap(List<String> lines) {
        var points = new ArrayList<Point>();

        for (var row = 0; row < lines.size(); row += 1) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col += 1) {
                if (line.charAt(col) == '#') {
                    points.add(new Point(col, row));
                }
            }
        }

        return points;
    }

    public List<Point> parse() {
        try {
            var lines = readLines();

            return parseMap(lines);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
