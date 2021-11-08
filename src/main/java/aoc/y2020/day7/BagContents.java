package aoc.y2020.day7;

public class BagContents {
    private int count;
    private String type;

    public BagContents(int count, String type) {
        this.count = count;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }
}
