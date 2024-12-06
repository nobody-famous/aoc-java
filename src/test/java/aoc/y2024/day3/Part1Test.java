package aoc.y2024.day3;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part1Test {
    @Test
    void testSample() {
        var lines = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        new Part1(null, 161).solve(lines);
    }
}
