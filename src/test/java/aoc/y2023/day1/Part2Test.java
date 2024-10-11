package aoc.y2023.day1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import aoc.y2023.Helpers;

public class Part2Test {
    @Test
    void testSample1() throws Exception {
        var lines = Arrays.asList(new String[] {
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen",
        });
        var part2 = new Part2(null, 281);

        part2.solve(Helpers.connectDB(), lines);
    }
}
