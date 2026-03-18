package aoc.y2024.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static final List<String> example1 = List.of(
            "AAAA",
            "BBCD",
            "BBCC",
            "EEEC");

    private static final List<String> example2 = List.of(
            "OOOOO",
            "OXOXO",
            "OOOOO",
            "OXOXO",
            "OOOOO");

    private static final List<String> example3 = List.of(
            "RRRRIICCFF",
            "RRRRIICCCF",
            "VVRRRCCFFF",
            "VVRCCCJFFF",
            "VVVVCJJCFE",
            "VVIVCCJJEE",
            "VVIIICJJEE",
            "MIIIIIJJEE",
            "MIIISIJEEE",
            "MMMISSJEEE");

    @Test
    void testPart1() {
        assertEquals(140, new Part1().solve(example1));
        assertEquals(772, new Part1().solve(example2));
        assertEquals(1930, new Part1().solve(example3));
    }
}
