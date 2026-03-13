package aoc.y2024.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static List<String> lines = List.of(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 4 7 10 13");

    @Test
    void testPart1() {
        assertEquals(2, new Part1().solve(lines));
    }

    @Test
    void testPart2() {
        assertEquals(4, new Part2().solve(lines));
    }
}
