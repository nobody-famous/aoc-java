package utils;

public abstract class Problem<T> implements AocProblem {
    private T expected;

    public abstract T run();

    protected Problem(T expected) {
        this.expected = expected;
    }

    public void solve() {
        var actual = run();

        if (!actual.equals(expected)) {
            throw new RuntimeException("Wrong answer: " + actual + " != " + expected);
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
