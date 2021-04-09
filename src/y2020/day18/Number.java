package y2020.day18;

public class Number implements Token {
    private long value;

    public Number(long value) {
        this.value = value;
    }

    public boolean isNumber() {
        return true;
    }

    public long getValue() {
        return value;
    }

    public String toString() {
        return "Number(" + value + ")";
    }
}
