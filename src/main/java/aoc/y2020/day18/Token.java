package aoc.y2020.day18;

public interface Token {
    default boolean isNumber() {
        return false;
    }

    default boolean isOpenParen() {
        return false;
    }

    default boolean isCloseParen() {
        return false;
    }

    default boolean isAdd() {
        return false;
    }

    default boolean isMultiply() {
        return false;
    }
}
