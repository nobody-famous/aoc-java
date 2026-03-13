package aoc.utils;

import java.util.List;

public interface AocProblem<T> {
    public abstract T solve(List<String> lines);
}
