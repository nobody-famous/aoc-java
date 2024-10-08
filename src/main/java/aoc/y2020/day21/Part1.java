package aoc.y2020.day21;

import java.util.HashMap;
import java.util.Map;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private Solver solver;

    public Part1(Food[] input, long expected) {
        super(expected);
        this.solver = new Solver(input);
    }

    private boolean isMissing(String ingr) {
        var found = false;

        for (var ingrsMap : solver.allergenMap.values()) {
            if (ingrsMap.containsKey(ingr)) {
                found = true;
                break;
            }
        }

        return !found;
    }

    private long countMissing(Map<String, Boolean> missing) {
        var count = 0L;

        for (var food : solver.input) {
            for (var ingr : food.getIngredients()) {
                if (missing.containsKey(ingr)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private Map<String, Boolean> findMissing() {
        var missing = new HashMap<String, Boolean>();

        for (var ingr : solver.allIngredients.keySet()) {
            if (isMissing(ingr)) {
                missing.put(ingr, true);
            }
        }

        return missing;
    }

    public Long run() {
        solver.buildMaps();

        var missing = findMissing();
        var answer = countMissing(missing);

        return answer;
    }
}
