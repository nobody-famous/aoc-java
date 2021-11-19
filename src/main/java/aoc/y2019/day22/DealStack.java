package aoc.y2019.day22;

public class DealStack implements Technique {
    @Override
    public int apply(int size, int index) {
        var endNdx = size - 1;
        return endNdx - index;
    }
}
