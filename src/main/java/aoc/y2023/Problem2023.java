package aoc.y2023;

import java.sql.Connection;
import java.util.List;

public abstract class Problem2023<T> implements AocProblem2023 {
    private T expected;
    private String fileName;

    public abstract T run(Connection conn, List<String> lines);

    protected Problem2023(String fileName, T expected) {
        this.fileName = fileName;
        this.expected = expected;
    }

    @Override
    public void solve(Connection conn, List<String> lines) throws Exception {
        conn.setAutoCommit(false);

        try {
            var actual = run(conn, lines);

            if (!actual.equals(expected)) {
                throw new RuntimeException("Wrong answer: " + actual + " != " + expected);
            }

            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        }
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    @Deprecated
    public void solve(List<String> lines) {
        throw new RuntimeException("Base solve method should not be called");
    }
}