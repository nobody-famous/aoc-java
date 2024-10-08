package aoc.y2023;

import aoc.utils.AocProblem;

public class Runner extends aoc.utils.Runner {
    public static AocProblem[] allDays = new AocProblem[] {
            new aoc.y2023.day1.Part1("input/2023/day1/puzzle.txt", 437),
    };

    public static void main(String[] args) throws Exception {
        var runner = new Runner();
        runner.runAll(allDays);
    }
}
