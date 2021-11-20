package aoc.y2019.day22;

public class DealIncrement implements Technique {
    private long increment;

    public DealIncrement(long increment) {
        this.increment = increment;
    }

    public long getIncrement() {
        return increment;
    }

    @Override
    public long apply(long size, long index) {
        return (index * increment) % size;
    }
}
