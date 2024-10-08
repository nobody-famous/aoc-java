package aoc.y2020;

import java.util.List;

import aoc.utils.Problem;

public abstract class Y2020Problem<T> extends Problem<T> {
    public Y2020Problem(T exp) {
        super("", exp);
    }

    public abstract T run();

    @Override
    public T run(List<String> lines) {
        return run();
    }
}
