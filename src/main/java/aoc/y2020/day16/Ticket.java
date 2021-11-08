package aoc.y2020.day16;

import java.util.List;

public class Ticket {
    private List<Long> values;

    public Ticket(List<Long> values) {
        this.values = values;
    }

    public List<Long> getValues() {
        return values;
    }
}
