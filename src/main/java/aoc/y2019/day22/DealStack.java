package aoc.y2019.day22;

public class DealStack implements Technique {
    @Override
    public long apply(long size, long index) {
        var endNdx = size - 1;
        return endNdx - index;
    }
}
