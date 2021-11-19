package aoc.y2019.day22;

public class CutCards implements Technique {
    private long numCards;

    public CutCards(long numCards) {
        this.numCards = numCards;
    }

    @Override
    public long apply(long size, long index) {
        return numCards < 0 ? cutEnd(size, index) : cutFront(size, index);
    }

    private long cutEnd(long size, long index) {
        var cut = size - Math.abs(numCards) - 1;

        return doCut(size, index, cut);
    }

    private long cutFront(long size, long index) {
        var cut = numCards - 1;

        return doCut(size, index, cut);
    }

    private long doCut(long size, long index, long cut) {
        if (index <= cut) {
            var endNdx = size - 1;
            var diff = cut - index;

            return endNdx - diff;
        }

        var start = cut + 1;
        return index - start;
    }
}
