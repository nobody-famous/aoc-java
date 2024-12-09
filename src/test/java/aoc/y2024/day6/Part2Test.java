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

        // (7,6)
        // (7,7)
        // (9,7)
        // (6,3)
        // (8,1)
        // (8,3)
        new Part2(null, 6).solve(lines);
    }
}
