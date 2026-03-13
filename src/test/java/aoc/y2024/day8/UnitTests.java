package aoc.y2024.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static final List<String> lines = List.of(
            "............",
            "........0...",
            ".....0......",
            ".......0....",
            "....0.......",
            "......A.....",
            "............",
            "............",
            "........A...",
            ".........A..",
            "............",
            "............");

    @Test
    void testPart1() {
        assertEquals(14, new Part1().solve(lines));
    }

    @Test
    void testPart2() {
        assertEquals(34, new Part2().solve(lines));
    }
}
