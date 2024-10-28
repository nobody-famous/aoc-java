package aoc.y2020.day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solver {
    public Food[] input;
    public Map<String, Map<String, Boolean>> allergenMap = new HashMap<>();
    public Map<String, Boolean> allIngredients = new HashMap<>();

    public Solver(Food[] input) {
        this.input = input;
    }

    public void buildMaps() {
        for (var food : input) {
            for (var ingredient : food.ingredients()) {
                allIngredients.put(ingredient, true);
            }

            for (var allergen : food.allergens()) {
                var ingrMap = listToMap(food.ingredients());
                updateAllergens(allergen, ingrMap);
            }
        }
    }

    public void updateAllergens(String allergen, Map<String, Boolean> ingredients) {
        if (!allergenMap.containsKey(allergen)) {
            allergenMap.put(allergen, ingredients);
            return;
        }

        var foodMap = allergenMap.get(allergen);
        var toRemove = new ArrayList<String>();

        for (var key : foodMap.keySet()) {
            if (!ingredients.containsKey(key)) {
                toRemove.add(key);
            }
        }

        for (var key : toRemove) {
            foodMap.remove(key);
        }
    }

    public Map<String, Boolean> listToMap(String[] list) {
        var out = new HashMap<String, Boolean>();

        for (var item : list) {
            out.put(item, true);
        }

        return out;
    }
}
