package aoc.y2024.day7;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static final List<String> lines = List.of(
            "190: 10 19",
            "3267: 81 40 27",
            "83: 17 5",
            "156: 15 6",
            "7290: 6 8 6 15",
            "161011: 16 10 13",
            "192: 17 8 14",
            "21037: 9 7 18 13",
            "292: 11 6 16 20");

    @Test
    void testPart1() {
        new Part1(null, 3749).solve(lines);
    }
}
