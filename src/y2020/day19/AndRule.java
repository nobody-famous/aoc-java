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

    public String toString() {
        var builder = new StringBuilder();

        builder.append("AndRule(");

        if (rules.length > 0) {
            builder.append(rules[0]);
            for (var ndx = 1; ndx < rules.length; ndx += 1) {
                builder.append(",");
                builder.append(rules[ndx]);
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
