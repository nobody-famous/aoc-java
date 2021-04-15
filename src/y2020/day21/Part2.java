package y2020.day21;

import java.util.ArrayList;
import java.util.Arrays;

public class Part2 extends Solver {
    public Part2(Food[] input) {
        super(input);
    }

    private boolean removeIngredient(String ingr) {
        var changed = false;

        for (var ingrsMap : allergenMap.values()) {
            if (ingrsMap.size() > 1 && ingrsMap.containsKey(ingr)) {
                ingrsMap.remove(ingr);
                changed = true;
            }
        }

        return changed;
    }

    private void reduceAllergens() {
        while (true) {
            var modified = false;

            for (var entry : allergenMap.entrySet()) {
                var ingrs = entry.getValue();

                if (ingrs.size() == 1) {
                    var ingr = ingrs.keySet().iterator().next();
                    modified |= removeIngredient(ingr);
                }
            }

            if (!modified) {
                break;
            }
        }
    }

    private String[] sortedAllergens() {
        var keys = allergenMap.keySet();
        var sorted = new String[keys.size()];

        var ndx = 0;
        for (var key : keys) {
            sorted[ndx] = key;
            ndx += 1;
        }

        Arrays.sort(sorted);

        return sorted;
    }

    public long solve() {
        buildMaps();
        reduceAllergens();

        var allergens = sortedAllergens();
        var ingrs = new ArrayList<String>();
        for (var allergen : allergens) {
            var ingrMap = allergenMap.get(allergen);
            var ingr = ingrMap.keySet().iterator().next();

            ingrs.add(ingr);
        }

        String.join(",", ingrs);

        return 0L;
    }
}
