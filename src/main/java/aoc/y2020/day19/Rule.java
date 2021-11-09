package aoc.y2020.day19;

public interface Rule {
    default boolean isChar() {
        return false;
    }

    default boolean isAnd() {
        return false;
    }

    default boolean isOr() {
        return false;
    }
}
