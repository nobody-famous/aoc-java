package aoc.y2023;

import java.sql.Connection;
import java.util.List;

import aoc.utils.AocProblem;

public interface AocProblem2023 extends AocProblem {
    void solve(Connection conn, List<String> lines);
}
