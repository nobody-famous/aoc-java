package aoc.y2019.day22;

public record DealIncrement(long increment) implements Technique {
    @Override
    public long apply(long size, long index) {
        return (index * increment) % size;
    }
}
