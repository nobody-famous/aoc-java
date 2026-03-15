package aoc.y2020.day21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    private boolean isMissing(Solver solver, String ingredient) {
        var found = false;

        for (var ingrsMap : solver.allergenMap.values()) {
            if (ingrsMap.containsKey(ingredient)) {
                found = true;
                break;
            }
        }

        return !found;
    }

    private int countMissing(Solver solver, Map<String, Boolean> missing) {
        var count = 0;

        for (var food : solver.input) {
            for (var ingredient : food.ingredients()) {
                if (missing.containsKey(ingredient)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private Map<String, Boolean> findMissing(Solver solver) {
        var missing = new HashMap<String, Boolean>();

        for (var ingredient : solver.allIngredients.keySet()) {
            if (isMissing(solver, ingredient)) {
                missing.put(ingredient, true);
            }
        }

        return missing;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var solver = new Solver(input);

        solver.buildMaps();

        var missing = findMissing(solver);

        return countMissing(solver, missing);
    }
}
