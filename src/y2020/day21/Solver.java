package y2020.day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public abstract class Solver implements Problem {
    protected Food[] input;
    protected Map<String, Map<String, Boolean>> allergenMap = new HashMap<String, Map<String, Boolean>>();
    protected Map<String, Boolean> allIngredients = new HashMap<String, Boolean>();

    protected Solver(Food[] input) {
        this.input = input;
    }

    protected void buildMaps() {
        for (var food : input) {
            for (var ingr : food.getIngredients()) {
                allIngredients.put(ingr, true);
            }

            for (var allergen : food.getAllergens()) {
                var ingrMap = listToMap(food.getIngredients());
                updateAllergens(allergen, ingrMap);
            }
        }
    }

    protected void updateAllergens(String allergen, Map<String, Boolean> ingrs) {
        if (!allergenMap.containsKey(allergen)) {
            allergenMap.put(allergen, ingrs);
            return;
        }

        var foodMap = allergenMap.get(allergen);
        var toRemove = new ArrayList<String>();

        for (var key : foodMap.keySet()) {
            if (!ingrs.containsKey(key)) {
                toRemove.add(key);
            }
        }

        for (var key : toRemove) {
            foodMap.remove(key);
        }
    }

    protected Map<String, Boolean> listToMap(String[] list) {
        var out = new HashMap<String, Boolean>();

        for (var item : list) {
            out.put(item, true);
        }

        return out;
    }
}
