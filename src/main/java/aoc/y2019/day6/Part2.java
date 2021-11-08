package aoc.y2019.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    private Parser parser;
    private Map<String, List<String>> orbits;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private List<String> findPath(List<String> curPath, String start, String end) {
        curPath.add(start);

        if (start.equals(end)) {
            return curPath;
        }

        if (!orbits.containsKey(start)) {
            return null;
        }

        var kids = orbits.get(start);

        for (var kid : kids) {
            var path = findPath(new ArrayList<String>(curPath), kid, end);

            if (path != null) {
                return path;
            }
        }

        return null;
    }

    private List<String> findPath(String start, String end) {
        return findPath(new ArrayList<String>(), start, end);
    }

    private List<String> findCommonBase(List<String> path1, List<String> path2) {
        var base = new ArrayList<String>();

        for (var ndx = 0; ndx < path1.size(); ndx += 1) {
            var entry1 = path1.get(ndx);
            var entry2 = path2.get(ndx);

            if (!entry1.equals(entry2)) {
                break;
            }

            base.add(entry1);
        }

        return base;
    }

    public Integer run() {
        orbits = parser.parse();

        var youPath = findPath("COM", "YOU");
        var sanPath = findPath("COM", "SAN");
        var base = findCommonBase(youPath, sanPath);

        var youDist = youPath.size() - base.size() - 1;
        var sanDist = sanPath.size() - base.size() - 1;

        return youDist + sanDist;
    }
}
