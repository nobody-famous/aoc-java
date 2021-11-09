package aoc.y2018.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<List<Claim>> {
    private Matcher matcher;

    public Parser(String fileName) {
        super(fileName);

        var pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        matcher = pattern.matcher("");
    }

    private Claim parseLine(String line) {
        matcher.reset(line);

        if (!matcher.matches()) {
            throw new RuntimeException("Failed to match: " + line);
        }

        var id = Integer.parseInt(matcher.group(1));
        var x = Integer.parseInt(matcher.group(2));
        var y = Integer.parseInt(matcher.group(3));
        var w = Integer.parseInt(matcher.group(4));
        var h = Integer.parseInt(matcher.group(5));

        return new Claim(id, new Point(x, y), w, h);
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
