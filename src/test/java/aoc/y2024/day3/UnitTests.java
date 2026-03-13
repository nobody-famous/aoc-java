package aoc.y2024.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    @Test
    void testPart1() {
        var lines = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        assertEquals(161, new Part1().solve(lines));
    }

    @Test
    void testPart2() {
        var lines = List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");
        assertEquals(48, new Part2().solve(lines));
    }
}
