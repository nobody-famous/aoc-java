package aoc.y2020;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Y2020Problem<T> implements AocProblem<T> {
    public abstract T run();

    @Override
    public T solve(List<String> lines) {
        return run();
    }
}
