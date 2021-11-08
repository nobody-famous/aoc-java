package aoc.y2020.day13;

public class Bus {
    private int id;
    private int offset;

    public Bus(int id, int offset) {
        this.id = id;
        this.offset = offset;
    }

    public int getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }
}
