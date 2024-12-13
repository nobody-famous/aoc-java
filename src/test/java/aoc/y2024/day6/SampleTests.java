package aoc.y2024.day6;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SampleTests {
    private static List<String> lines = List.of(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#...");

    @Test
    void testPart1() {
        new Part1(null, 41).solve(lines);
    }

    @Test
    void testPart2() {
        new Part2(null, 6).solve(lines);
    }
}
