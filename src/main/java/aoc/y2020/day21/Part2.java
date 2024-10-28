package aoc.y2020.day21;

import java.util.ArrayList;
import java.util.Arrays;

import aoc.y2020.Y2020Problem;

public class Part2 extends Y2020Problem<String> {
    private final Solver solver;

    public Part2(Food[] input, String expected) {
        super(expected);
        this.solver = new Solver(input);
    }

    private boolean removeIngredient(String ingredient) {
        var changed = false;

        for (var ingrsMap : solver.allergenMap.values()) {
            if (ingrsMap.size() > 1 && ingrsMap.containsKey(ingredient)) {
                ingrsMap.remove(ingredient);
                changed = true;
            }
        }

        return changed;
    }

    private void reduceAllergens() {
        while (true) {
            var modified = false;

            for (var entry : solver.allergenMap.entrySet()) {
                var ingredients = entry.getValue();

                if (ingredients.size() == 1) {
                    var ingredient = ingredients.keySet().iterator().next();
                    modified |= removeIngredient(ingredient);
                }
            }

            if (!modified) {
                break;
            }
        }
    }

    private String[] sortedAllergens() {
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

    public String run() {
        solver.buildMaps();
        reduceAllergens();

        var allergens = sortedAllergens();
        var ingredients = new ArrayList<String>();
        for (var allergen : allergens) {
            var ingrMap = solver.allergenMap.get(allergen);
            var ingredient = ingrMap.keySet().iterator().next();

            ingredients.add(ingredient);
        }

        return String.join(",", ingredients);
    }
}
