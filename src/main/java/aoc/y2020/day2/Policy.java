package aoc.y2020.day2;

public class Policy {
    private int low;
    private int high;
    private char letter;

    public Policy(int low, int high, char letter) {
        this.low = low;
        this.high = high;
        this.letter = letter;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public char getLetter() {
        return letter;
    }
}
