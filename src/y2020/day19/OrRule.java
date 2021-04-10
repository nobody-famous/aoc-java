package y2020.day19;

public class OrRule implements Rule {
    private Rule left;
    private Rule right;

    public OrRule(Rule left, Rule right) {
        this.left = left;
        this.right = right;
    }

    public boolean isOr() {
        return true;
    }

    public Rule getLeft() {
        return left;
    }

    public Rule getRight() {
        return right;
    }
}
