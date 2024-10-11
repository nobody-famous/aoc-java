package aoc.y2023.day1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import aoc.y2023.Helpers;

public class Part1Test {
    @Test
    void testSample1() throws Exception {
        var lines = Arrays.asList(new String[] {
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet",
        });
        var part1 = new Part1(null, 142);

        part1.solve(Helpers.connectDB(), lines);
    }
}
