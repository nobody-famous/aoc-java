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
    private static final List<String> example4 = List.of(
            "EEEEE",
            "EXXXX",
            "EEEEE",
            "EXXXX",
            "EEEEE");
    private static final List<String> example5 = List.of(
            "AAAAAA",
            "AAABBA",
            "AAABBA",
            "ABBAAA",
            "ABBAAA",
            "AAAAAA");

    @Test
    void testPart1() {
        assertEquals(140, new Part1().solve(example1));
        assertEquals(772, new Part1().solve(example2));
        assertEquals(1930, new Part1().solve(example3));
    }

    @Test
    void testPart2() {
        assertEquals(80, new Part2().solve(example1));
        assertEquals(436, new Part2().solve(example2));
        assertEquals(1206, new Part2().solve(example3));
        assertEquals(236, new Part2().solve(example4));
        assertEquals(368, new Part2().solve(example5));
    }
}
