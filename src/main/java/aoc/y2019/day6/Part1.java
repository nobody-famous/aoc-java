package aoc.y2019.day6;

import java.util.List;
import java.util.Map;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int countOrbits(Map<String, List<String>> orbits, String node, int curTotal) {
        if (!orbits.containsKey(node)) {
            return 0;
        }

        var kids = orbits.get(node);
        var total = kids.size() * (curTotal + 1);

        for (var kid : kids) {
            total += countOrbits(orbits, kid, curTotal + 1);
        }

        return total;
    }

    @Override
    public Integer run(List<String> lines) {
        var orbits = parser.parse(lines);

        return countOrbits(orbits, "COM", 0);
    }
}
