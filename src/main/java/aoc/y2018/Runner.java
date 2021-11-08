package aoc.y2018;
import aoc.utils.AocProblem;

public class Runner extends aoc.utils.Runner {
    public static AocProblem[] allDays = new AocProblem[] { new aoc.y2018.day1.Part1("input/2018/day1/puzzle.txt", 437),
            new aoc.y2018.day1.Part2("input/2018/day1/puzzle.txt", 655),
            new aoc.y2018.day2.Part1("input/2018/day2/puzzle.txt", 6225),
            new aoc.y2018.day2.Part2("input/2018/day2/puzzle.txt", "revtaubfniyhsgxdoajwkqilp"),
            new aoc.y2018.day3.Part1("input/2018/day3/puzzle.txt", 118858),
            new aoc.y2018.day3.Part2("input/2018/day3/puzzle.txt", 1100),
            new aoc.y2018.day4.Part1("input/2018/day4/puzzle.txt", 39698),
            new aoc.y2018.day4.Part2("input/2018/day4/puzzle.txt", 14920) };

    public static void main(String[] args) {
        var runner = new Runner();

        // var allDays = new AocProblem[] { new y2018.day4.Part2("input/2018/day4/puzzle.txt", 14920) };

        runner.runAll(allDays);
    }
}
