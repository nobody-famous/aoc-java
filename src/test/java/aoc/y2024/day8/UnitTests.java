package aoc.y2024.day8;

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
        new Part1(null, 14).solve(lines);
    }
}
