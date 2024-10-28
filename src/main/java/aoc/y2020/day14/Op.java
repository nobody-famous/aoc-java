package aoc.y2020.day14;

public interface Op {
    enum Type {
        MASK, MEMORY
    }

    Type getType();
}
