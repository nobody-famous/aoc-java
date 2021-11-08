package aoc.y2020.day16;

import java.util.List;

public class Field {
    private String name;
    private List<Range> ranges;

    public Field(String name, List<Range> ranges) {
        this.name = name;
        this.ranges = ranges;
    }

    public String getName() {
        return name;
    }

    public List<Range> getRanges() {
        return ranges;
    }
}
