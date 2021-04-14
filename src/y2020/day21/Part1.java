package y2020.day21;

import java.util.HashMap;
import java.util.Map;

public class Part1 extends Solver {
    public Part1(Food[] input) {
        super(input);
    }

    private boolean isMissing(String ingr) {
        var found = false;

        for (var ingrsMap : allergenMap.values()) {
            if (ingrsMap.containsKey(ingr)) {
                found = true;
                break;
            }
        }

        return !found;
    }

    private long countMissing(Map<String, Boolean> missing) {
        var count = 0L;

        for (var food : input) {
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

        for (var ingr : allIngredients.keySet()) {
            if (isMissing(ingr)) {
                missing.put(ingr, true);
            }
        }

        return missing;
    }

    public long solve() {
        buildMaps();

        var missing = findMissing();
        var answer = countMissing(missing);

        return answer;
    }
}
