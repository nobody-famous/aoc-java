package aoc.y2020.day21;

import java.util.HashMap;
import java.util.Map;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private final Solver solver;

    public Part1(Food[] input, long expected) {
        super(expected);
        this.solver = new Solver(input);
    }

    private boolean isMissing(String ingredient) {
        var found = false;

        for (var ingrsMap : solver.allergenMap.values()) {
            if (ingrsMap.containsKey(ingredient)) {
                found = true;
                break;
            }
        }

        return !found;
    }

    private long countMissing(Map<String, Boolean> missing) {
        var count = 0L;

        for (var food : solver.input) {
            for (var ingredient : food.ingredients()) {
                if (missing.containsKey(ingredient)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private Map<String, Boolean> findMissing() {
        var missing = new HashMap<String, Boolean>();

        for (var ingredient : solver.allIngredients.keySet()) {
            if (isMissing(ingredient)) {
                missing.put(ingredient, true);
            }
        }

        return missing;
    }

    public Long run() {
        solver.buildMaps();

        var missing = findMissing();

        return countMissing(missing);
    }
}
