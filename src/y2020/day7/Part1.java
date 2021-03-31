package y2020.day7;

import java.util.HashMap;
import java.util.Map;

public class Part1 {
    private Map<String, BagContents[]> rulesToMap(BagRule[] rules) {
        var out = new HashMap<String, BagContents[]>();

        for (var rule : rules) {
            out.put(rule.getType(), rule.getContents());
        }

        return out;
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

    public long solve(BagRule[] input) {
        long answer = 0;
        var rules = rulesToMap(input);

        for (var bag : rules.keySet()) {
            if (hasTarget("shiny gold", rules, bag)) {
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
