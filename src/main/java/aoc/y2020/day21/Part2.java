package aoc.y2020.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<String> {
    private boolean removeIngredient(Solver solver, String ingredient) {
        var changed = false;

        for (var ingrsMap : solver.allergenMap.values()) {
            if (ingrsMap.size() > 1 && ingrsMap.containsKey(ingredient)) {
                ingrsMap.remove(ingredient);
                changed = true;
            }
        }

        return changed;
    }

    private void reduceAllergens(Solver solver) {
        while (true) {
            var modified = false;

            for (var entry : solver.allergenMap.entrySet()) {
                var ingredients = entry.getValue();

                if (ingredients.size() == 1) {
                    var ingredient = ingredients.keySet().iterator().next();
                    modified |= removeIngredient(solver, ingredient);
                }
            }

            if (!modified) {
                break;
            }
        }
    }

    private String[] sortedAllergens(Solver solver) {
        var keys = solver.allergenMap.keySet();
        var sorted = new String[keys.size()];

        var ndx = 0;
        for (var key : keys) {
            sorted[ndx] = key;
            ndx += 1;
        }

        Arrays.sort(sorted);

        return sorted;
    }

    @Override
    public String solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var solver = new Solver(input);

        solver.buildMaps();
        reduceAllergens(solver);

        var allergens = sortedAllergens(solver);
        var ingredients = new ArrayList<String>();
        for (var allergen : allergens) {
            var ingrMap = solver.allergenMap.get(allergen);
            var ingredient = ingrMap.keySet().iterator().next();

            ingredients.add(ingredient);
        }

        return String.join(",", ingredients);
    }
}
