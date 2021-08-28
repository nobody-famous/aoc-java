package y2019.day6;

import java.util.List;
import java.util.Map;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        this.parser = new Parser(fileName);
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

    public Integer run() {
        var orbits = parser.parse();

        return countOrbits(orbits, "COM", 0);
    }
}
