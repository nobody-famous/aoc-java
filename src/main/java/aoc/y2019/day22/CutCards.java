package aoc.y2019.day22;

public class CutCards implements Technique {
    private int numCards;

    public CutCards(int numCards) {
        this.numCards = numCards;
    }

    @Override
    public int apply(int size, int index) {
        return numCards < 0 ? cutEnd(size, index) : cutFront(size, index);
    }

    private int cutEnd(int size, int index) {
        var cut = size - Math.abs(numCards) - 1;

        return doCut(size, index, cut);
    }

    private int cutFront(int size, int index) {
        var cut = numCards - 1;

        return doCut(size, index, cut);
    }

    private int doCut(int size, int index, int cut) {
        if (index <= cut) {
            var endNdx = size - 1;
            var diff = cut - index;

            return endNdx - diff;
        }

        var start = cut + 1;
        return index - start;
    }
}
