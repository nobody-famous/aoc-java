package y2018.day3;

import java.util.ArrayList;
import java.util.List;

import utils.geometry.Point;

public class Parser extends utils.Parser<List<Claim>> {
    public Parser(String fileName) {
        super(fileName);
    }

    private Point parsePoint(String str, char ch) {
        var ndx = str.indexOf(ch);
        var x = Integer.parseInt(str.substring(0, ndx).trim());
        var y = Integer.parseInt(str.substring(ndx + 1).trim());

        return new Point(x, y);
    }

    private Claim parseLine(String line) {
        var ndx = line.indexOf('@');
        var first = line.substring(0, ndx).trim();
        var last = line.substring(ndx + 1).trim();
        var id = Integer.parseInt(first.substring(1));

        var ndx2 = last.indexOf(':');
        var ptStr = last.substring(0, ndx2).trim();
        var dimStr = last.substring(ndx2 + 1).trim();

        var pt = parsePoint(ptStr, ',');
        var rect = parsePoint(dimStr, 'x');

        return new Claim(id, pt, rect.x, rect.y);
    }

    @Override
    public List<Claim> parse() {
        try {
            var lines = readLines();
            var claims = new ArrayList<Claim>();

            for (var line : lines) {
                claims.add(parseLine(line));
            }

            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
