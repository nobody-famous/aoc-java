package y2020.day19;

public class AndRule implements Rule {
    private int[] rules;

    public AndRule(int[] rules) {
        this.rules = rules;
    }

    public boolean isAnd() {
        return true;
    }

    public int[] getRules() {
        return rules;
    }
}
