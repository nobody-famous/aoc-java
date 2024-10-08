package aoc.utils;

import java.util.List;

public interface AocProblem {
    void solve(List<String> lines);

    String getFileName();
}
