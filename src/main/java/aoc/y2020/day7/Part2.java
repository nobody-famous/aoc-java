package aoc.y2020.day7;

import java.util.Map;

public class Part2 extends Solver {
    public Part2(BagRule[] input, long expected) {
        super(input, expected);
    }

    private long countBags(Map<String, BagContents[]> rules, String bag) {
        long count = 0;
        var content = rules.get(bag);

        if (content == null) {
            return 0;
        }

        for (var entry : content) {
            count += entry.count();
            count += entry.count() * countBags(rules, entry.type());
        }

        return count;
    }

    public Long run() {
        var rules = rulesToMap(input);

        return countBags(rules, "shiny gold");
    }
}
