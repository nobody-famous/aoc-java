package aoc.y2024.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
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
        assertEquals(41, new Part1().solve(lines));
    }

    @Test
    void testPart2() {
        assertEquals(6, new Part2().solve(lines));
    }
}
