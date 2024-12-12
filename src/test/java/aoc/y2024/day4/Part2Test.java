package aoc.y2024.day4;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part2Test {
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

        new Part2(null, 9).solve(lines);
    }
}
