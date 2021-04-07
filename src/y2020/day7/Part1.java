package y2020.day7;

import java.util.Map;

public class Part1 extends Solver {
    public Part1(BagRule[] input) {
        super(input);
    }

    private boolean hasTarget(String target, Map<String, BagContents[]> rules, String bag) {
        var contents = rules.get(bag);

        for (var content : contents) {
            if (target.equals(content.getType())) {
                return true;
            }
        }

        for (var content : contents) {
            if (hasTarget(target, rules, content.getType())) {
                return true;
            }
        }

        return false;
    }

    public long solve() {
        long answer = 0;
        var rules = rulesToMap(input);

        for (var bag : rules.keySet()) {
            if (hasTarget("shiny gold", rules, bag)) {
                answer += 1;
            }
        }

        return answer;
    }
}
