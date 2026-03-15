package aoc.y2020.day7;

import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    private int countBags(Map<String, List<BagContents>> rules, String bag) {
        var count = 0;
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

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var rules = rulesToMap(input);

        return countBags(rules, "shiny gold");
    }
}
