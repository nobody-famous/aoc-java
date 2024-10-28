package aoc.y2020.day19;

public record OrRule(Rule left, Rule right) implements Rule {

    public boolean isOr() {
        return true;
    }

    public String toString() {
        return "OrRule(" + left + " | " + right + ")";
    }
}
