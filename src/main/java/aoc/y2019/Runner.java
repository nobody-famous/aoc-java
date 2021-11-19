package aoc.y2019;

import aoc.utils.AocProblem;

public class Runner extends aoc.utils.Runner {
    public static AocProblem[] allDays = new AocProblem[] {
            new aoc.y2019.day1.Part1("input/2019/day1/puzzle.txt", 3279287),
            new aoc.y2019.day1.Part2("input/2019/day1/puzzle.txt", 4916076),
            new aoc.y2019.day2.Part1("input/2019/day2/puzzle.txt", 3101844),
            new aoc.y2019.day2.Part2("input/2019/day2/puzzle.txt", 8478),
            new aoc.y2019.day3.Part1("input/2019/day3/puzzle.txt", 529),
            new aoc.y2019.day3.Part2("input/2019/day3/puzzle.txt", 20386),
            new aoc.y2019.day4.Part1("input/2019/day4/puzzle.txt", 511),
            new aoc.y2019.day4.Part2("input/2019/day4/puzzle.txt", 316),
            new aoc.y2019.day5.Part1("input/2019/day5/puzzle.txt", 13294380),
            new aoc.y2019.day5.Part2("input/2019/day5/puzzle.txt", 11460760),
            new aoc.y2019.day6.Part1("input/2019/day6/puzzle.txt", 162816),
            new aoc.y2019.day6.Part2("input/2019/day6/puzzle.txt", 304),
            new aoc.y2019.day7.Part1("input/2019/day7/puzzle.txt", 21760),
            new aoc.y2019.day7.Part2("input/2019/day7/puzzle.txt", 69816958),
            new aoc.y2019.day8.Part1("input/2019/day8/puzzle.txt", 2356),
            new aoc.y2019.day8.Part2("input/2019/day8/puzzle.txt", "PZEKB"),
            new aoc.y2019.day9.Part1("input/2019/day9/puzzle.txt", 2870072642L),
            new aoc.y2019.day9.Part2("input/2019/day9/puzzle.txt", 58534L),
            new aoc.y2019.day10.Part1("input/2019/day10/puzzle.txt", 347),
            new aoc.y2019.day10.Part2("input/2019/day10/puzzle.txt", 829),
            new aoc.y2019.day11.Part1("input/2019/day11/puzzle.txt", 1885),
            new aoc.y2019.day11.Part2("input/2019/day11/puzzle.txt", "BFEAGHAF"),
            new aoc.y2019.day12.Part1("input/2019/day12/puzzle.txt", 7077),
            new aoc.y2019.day12.Part2("input/2019/day12/puzzle.txt", 402951477454512L),
            new aoc.y2019.day13.Part1("input/2019/day13/puzzle.txt", 251),
            new aoc.y2019.day13.Part2("input/2019/day13/puzzle.txt", 12779),
            new aoc.y2019.day14.Part1("input/2019/day14/puzzle.txt", 136771),
            new aoc.y2019.day14.Part2("input/2019/day14/puzzle.txt", 8193614),
            new aoc.y2019.day15.Part1("input/2019/day15/puzzle.txt", 254),
            new aoc.y2019.day15.Part2("input/2019/day15/puzzle.txt", 268),
            new aoc.y2019.day16.Part1("input/2019/day16/puzzle.txt", 68764632),
            new aoc.y2019.day16.Part2("input/2019/day16/puzzle.txt", 52825021),
            new aoc.y2019.day17.Part1("input/2019/day17/puzzle.txt", 8928),
            new aoc.y2019.day17.Part2("input/2019/day17/puzzle.txt", 880360),
            new aoc.y2019.day18.Part1("input/2019/day18/puzzle.txt", 3048),
            new aoc.y2019.day18.Part2("input/2019/day18/puzzle2.txt", 1732),
            new aoc.y2019.day19.Part1("input/2019/day19/puzzle.txt", 234),
            new aoc.y2019.day19.Part2("input/2019/day19/puzzle.txt", 9290812),
            new aoc.y2019.day20.Part1("input/2019/day20/puzzle.txt", 526),
            new aoc.y2019.day20.Part2("input/2019/day20/puzzle.txt", 6292),
            new aoc.y2019.day21.Part1("input/2019/day21/puzzle.txt", 19359316),
            new aoc.y2019.day21.Part2("input/2019/day21/puzzle.txt", 1141281622) };

    public static void main(String[] args) {
        var runner = new Runner();

        var allDays = new AocProblem[] { new aoc.y2019.day22.Part1("input/2019/day22/puzzle.txt", 4703) };

        runner.runAll(allDays);
    }
}
