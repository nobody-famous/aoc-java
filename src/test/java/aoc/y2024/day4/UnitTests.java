package aoc.y2024.day4;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static List<String> lines = List.of(
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

    @Test
    void testPart1() {
        new Part1(null, 18).solve(lines);
    }

    @Test
    void testPart2() {
        new Part2(null, 9).solve(lines);
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

        new Part1(null, 5).solve(lines);
    }
}
