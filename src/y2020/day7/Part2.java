package y2020.day7;

import java.util.Map;

public class Part2 extends Solver {
    public Part2(BagRule[] input) {
        super(input);
    }

    private long countBags(Map<String, BagContents[]> rules, String bag) {
        long count = 0;
        var content = rules.get(bag);

        if (content == null) {
            return 0;
        }

        for (var entry : content) {
            count += entry.getCount();
            count += entry.getCount() * countBags(rules, entry.getType());
        }

        return count;
    }

    public long solve() {
        long answer = 0;
        var rules = rulesToMap(input);

        answer = countBags(rules, "shiny gold");

        return answer;
    }
}
