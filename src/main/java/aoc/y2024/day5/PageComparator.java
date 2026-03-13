package aoc.y2024.day5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;

public class PageComparator implements Comparator<Integer> {
    private Rules rules;

    public PageComparator(Rules rules) {
        this.rules = rules;
    }

    @Override
    public int compare(Integer left, Integer right) {
        Optional<HashSet<Integer>> leftRules = rules.getOrderings().containsKey(left)
                ? Optional.of(rules.getOrderings().get(left))
                : Optional.empty();
        Optional<HashSet<Integer>> rightRules = rules.getOrderings().containsKey(right)
                ? Optional.of(rules.getOrderings().get(right))
                : Optional.empty();

        if (leftRules.isPresent() && leftRules.get().contains(right)) {
            return -1;
        } else if (rightRules.isPresent() && rightRules.get().contains(left)) {
            return 1;
        }

        return 0;
    }
}
