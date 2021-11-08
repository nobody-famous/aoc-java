package aoc.y2020.day21;

public class Food {
    private String[] ingredients;
    private String[] allergens;

    public Food(String[] ingredients, String[] allergens) {
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getAllergens() {
        return allergens;
    }
}
