package aoc.y2024.day10;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTests {
    private static final List<String> example1 = List.of(
            "0123",
            "1234",
            "8765",
            "9876");

    private static final List<String> example2 = List.of(
            "...0...",
            "...1...",
            "...2...",
            "6543456",
            "7.....7",
            "8.....8",
            "9.....9");

    private static final List<String> example3 = List.of(
            "..90..9",
            "...1.98",
            "...2..7",
            "6543456",
            "765.987",
            "876....",
            "987....");

    private static final List<String> example4 = List.of(
            "10..9..",
            "2...8..",
            "3...7..",
            "4567654",
            "...8..3",
            "...9..2",
            ".....01");

    private static final List<String> example5 = List.of(
            "89010123",
            "78121874",
            "87430965",
            "96549874",
            "45678903",
            "32019012",
            "01329801",
            "10456732");

    @Test
    void testPart1() {
        new Part1(null, 1).solve(example1);
        new Part1(null, 2).solve(example2);
        new Part1(null, 4).solve(example3);
        new Part1(null, 3).solve(example4);
        new Part1(null, 36).solve(example5);
    }
}
