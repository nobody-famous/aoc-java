package aoc.y2024.day1;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static List<String> lines = List.of(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3");

    @Test
    void testPart1() {
        new Part1(null, 11).solve(lines);
    }

    @Test
    void testPart2() {
        new Part2(null, 31).solve(lines);
    }
}
