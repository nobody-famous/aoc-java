package aoc.y2024.day6;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part1Test {
    @Test
    void testSample() {
        var lines = List.of(
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

        new Part1(null, 41).solve(lines);
    }
}
