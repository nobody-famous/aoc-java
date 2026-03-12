package aoc.y2019.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aoc.utils.IntProblem;

public class Part2 extends IntProblem {
    private final Parser parser = new Parser();
    private Map<String, List<String>> orbits;

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
            var path = findPath(new ArrayList<>(curPath), kid, end);

            if (path != null) {
                return path;
            }
        }

        return null;
    }

    private List<String> findPath(String end) {
        return findPath(new ArrayList<>(), "COM", end);
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

    @Override
    public int solve(List<String> lines) {
        orbits = parser.parse(lines);

        var youPath = findPath("YOU");
        var sanPath = findPath("SAN");
        var base = findCommonBase(youPath, sanPath);

        var youDist = youPath.size() - base.size() - 1;
        var sanDist = sanPath.size() - base.size() - 1;

        return youDist + sanDist;
    }
}
