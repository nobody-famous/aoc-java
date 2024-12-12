package aoc.y2024.day4;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part1Test {
    @Test
    void testSample() {
        var lines = List.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX");

        new Part1(null, 18).solve(lines);
    }

    @Test
    void testManual() {
        var lines = List.of(
                "SMAS",
                "AMAS",
                "MMAS",
                "XMAS",
                "MMAS",
                "AMAS",
                "SMAS");

        System.out.println("***** MANUAL TEST");
        new Part1(null, 5).solve(lines);
    }
}
