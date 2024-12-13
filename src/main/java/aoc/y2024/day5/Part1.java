package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.List;

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
        return false;
    }
}
