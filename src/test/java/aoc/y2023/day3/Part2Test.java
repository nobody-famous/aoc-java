package aoc.y2023.day3;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import aoc.y2023.Helpers;

public class Part2Test {
    @Test
    void sample() throws Exception {
        var lines = Arrays.asList(new String[] {
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..",
        });
        var part2 = new Part2(null, 467835);

        part2.solve(Helpers.connectDB(), lines);
    }
}
