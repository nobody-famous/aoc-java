package aoc.y2024.day17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private final static List<String> example1 = List.of(
            "Register A: 729",
            "Register B: 0",
            "Register C: 0",
            "",
            "Program: 0,1,5,4,3,0");

    private final static List<String> example2 = List.of(
            "Register A: 2024",
            "Register B: 0",
            "Register C: 0",
            "",
            "Program: 0,3,5,4,3,0");

    @Test
    void testPart1() {
        assertEquals("4,6,3,5,6,3,5,2,1,0", new Part1().solve(example1));
    }

    @Test
    void testPart2() {
        assertEquals(117440, new Part2().solve(example2));
    }
}
