package aoc.y2023.day3;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import aoc.y2023.Helpers;

public class Part1Test {
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
        var part1 = new Part1(null, 4361);

        part1.solve(Helpers.connectDB(), lines);
    }
}
