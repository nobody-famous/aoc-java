package aoc.y2024.day6;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part2Test {
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

        new Part2(null, 6).solve(lines);
    }
}
