package aoc.y2019.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.geometry.Point3D;

public class Parser extends aoc.utils.Parser<List<Moon>> {
    private Matcher regex;

    public Parser() {
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

    @Override
    public List<Moon> parse(List<String> lines) {
        try {
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
