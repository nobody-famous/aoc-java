package aoc.y2024.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static final List<String> exmple = List.of(
            "125 17");

    @Test
    void testPart1() {
        assertEquals(55312, new Part1().solve(exmple));
    }
}
