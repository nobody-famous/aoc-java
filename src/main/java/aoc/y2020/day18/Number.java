package aoc.y2020.day18;

public record Number(long value) implements Token {
    public boolean isNumber() {
        return true;
    }

    public String toString() {
        return "Number(" + value + ")";
    }
}
