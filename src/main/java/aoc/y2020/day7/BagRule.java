package aoc.y2020.day7;

public class BagRule {
    private String type;
    private BagContents[] contents;

    public BagRule(String type, BagContents[] contents) {
        this.type = type;
        this.contents = contents;
    }

    public String getType() {
        return type;
    }

    public BagContents[] getContents() {
        return contents;
    }
}
