package aoc.utils;

import java.util.List;

public interface Parser<T> {
    public T parse(List<String> lines);
}
