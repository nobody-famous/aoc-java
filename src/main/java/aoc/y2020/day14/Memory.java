package aoc.y2020.day14;

public record Memory(long address, long value) implements Op {
    public Type getType() {
        return Type.MEMORY;
    }
}
