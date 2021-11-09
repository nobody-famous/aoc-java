package aoc.y2019.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.geometry.Point3D;

public class Parser extends aoc.utils.Parser<List<Moon>> {
    private Matcher regex;

    public Parser(String fileName) {
        super(fileName);

        var moonRegex = Pattern.compile("<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>");
        regex = moonRegex.matcher("");
    }

    private Moon parseLine(String line) {
        regex.reset(line);

        if (!regex.matches()) {
            throw new RuntimeException("regex failed: " + line);
        }

        var x = Integer.parseInt(regex.group(1));
        var y = Integer.parseInt(regex.group(2));
        var z = Integer.parseInt(regex.group(3));

        return new Moon(new Point3D(x, y, z));
    }

    public List<Moon> parse() {
        try {
            var lines = readLines();
            var moons = new ArrayList<Moon>();

            for (var line : lines) {
                moons.add(parseLine(line));
            }

            return moons;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
