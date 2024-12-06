package aoc.y2024.day1;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part1Test {
    @Test
    void testSample() {
        var lines = List.of(
                "3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3");

        new Part1(null, 11).solve(lines);
    }
}
