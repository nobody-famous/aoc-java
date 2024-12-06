package aoc.y2024.day2;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Part2Test {
    @Test
    void testSample() {
        var lines = List.of(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 4 7 10 13");
        var part1 = new Part2(null, 4);

        part1.solve(lines);
    }
}
