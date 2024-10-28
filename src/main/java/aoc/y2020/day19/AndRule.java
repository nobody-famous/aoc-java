package aoc.y2020.day19;

public record AndRule(int[] rules) implements Rule {

    public boolean isAnd() {
        return true;
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
