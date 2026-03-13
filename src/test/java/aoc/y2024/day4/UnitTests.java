package aoc.y2024.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(18, new Part1().solve(lines));
    }

    @Test
    void testPart2() {
        assertEquals(9, new Part2().solve(lines));
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

        assertEquals(5, new Part1().solve(lines));
    }
}
