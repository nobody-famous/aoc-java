package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var rules = new Parser().parse(lines);
        var validUpdates = findValidUpdates(rules);
        var answer = 0;

        for (var update : validUpdates) {
            var mid = update.size() / 2;

            answer += update.get(mid);
        }

        return answer;
    }

    private List<List<Integer>> findValidUpdates(Rules rules) {
        var updates = new ArrayList<List<Integer>>();

        for (var update : rules.getUpdates()) {
            if (isInOrder(rules, update)) {
                updates.add(update);
            }
        }

        return updates;
    }

    private boolean isInOrder(Rules rules, List<Integer> update) {
        for (var cur = 0; cur < update.size(); cur += 1) {
            var curPage = update.get(cur);

            Optional<HashSet<Integer>> curRules = rules.getOrderings().containsKey(curPage)
                    ? Optional.of(rules.getOrderings().get(curPage))
                    : Optional.empty();

            for (var next = cur + 1; next < update.size(); next += 1) {
                var nextPage = update.get(next);
                Optional<HashSet<Integer>> nextRules = rules.getOrderings().containsKey(nextPage)
                        ? Optional.of(rules.getOrderings().get(nextPage))
                        : Optional.empty();

                if (curRules.isPresent() && !curRules.get().contains(nextPage)) {
                    return false;
                } else if (nextRules.isPresent() && nextRules.get().contains(curPage)) {
                    return false;
                }
            }
        }

        return true;
    }
}
