package aoc.utils;

import java.util.List;

public abstract class Problem<T> implements AocProblem {
    private T expected;
    private String fileName;

    public abstract T run(List<String> lines);

    protected Problem(String fileName, T expected) {
        this.fileName = fileName;
        this.expected = expected;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void solve(List<String> lines) {
        var actual = run(lines);

        if (!actual.equals(expected)) {
            throw new RuntimeException("Wrong answer: " + actual + " != " + expected);
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
