package aoc.y2020.day7;

import java.util.List;
import java.util.Map;

public class Part1 extends Solver {
    private boolean hasTarget(String target, Map<String, List<BagContents>> rules, String bag) {
        var contents = rules.get(bag);

        return contents.stream().anyMatch(c -> target.equals(c.type()))
                || contents.stream().anyMatch(c -> hasTarget(target, rules, c.type()));
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var answer = 0;
        var rules = rulesToMap(input);

        for (var bag : rules.keySet()) {
            if (hasTarget("shiny gold", rules, bag)) {
                answer += 1;
            }
        }

        return answer;
    }
}
