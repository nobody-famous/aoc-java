package aoc.utils;

import java.util.List;

public abstract class Parser<T> {
    public Parser() {
    }

    public abstract T parse(List<String> lines);
}
