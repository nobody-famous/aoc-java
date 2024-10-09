package aoc.y2023.day1;

import java.sql.Connection;
import java.util.List;

import aoc.y2023.AocProblem2023;

public class Part1 implements AocProblem2023 {
    private String fileName;

    public Part1(String fileName, int exp) {
        this.fileName = fileName;
    }

    @Override
    public void solve(Connection conn, List<String> lines) {
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void solve(List<String> lines) {
        throw new RuntimeException("Base solve method should not be called");
    }
}
