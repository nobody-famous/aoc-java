package aoc.y2019.day22;

public class DealIncrement implements Technique {
    private int increment;

    public DealIncrement(int increment) {
        this.increment = increment;
    }

    @Override
    public int apply(int size, int index) {
        return (index * increment) % size;
    }
}
