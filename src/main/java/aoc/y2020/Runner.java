package aoc.y2020;

import aoc.utils.AocProblem;

public class Runner extends aoc.utils.Runner {
    public static AocProblem[] allDays = new AocProblem[] {
            new aoc.y2020.day1.Part1(aoc.y2020.day1.Input.puzzle, 972576),
            new aoc.y2020.day1.Part2(aoc.y2020.day1.Input.puzzle, 199300880),
            new aoc.y2020.day2.Part1(aoc.y2020.day2.Input.puzzle, 564),
            new aoc.y2020.day2.Part2(aoc.y2020.day2.Input.puzzle, 325),
            new aoc.y2020.day3.Part1(aoc.y2020.day3.Input.puzzle, 145),
            new aoc.y2020.day3.Part2(aoc.y2020.day3.Input.puzzle, 3424528800L),
            new aoc.y2020.day4.Part1(aoc.y2020.day4.Input.puzzle, 213),
            new aoc.y2020.day4.Part2(aoc.y2020.day4.Input.puzzle, 147),
            new aoc.y2020.day5.Part1(aoc.y2020.day5.Input.puzzle, 994),
            new aoc.y2020.day5.Part2(aoc.y2020.day5.Input.puzzle, 741),
            new aoc.y2020.day6.Part1(aoc.y2020.day6.Input.puzzle, 6587),
            new aoc.y2020.day6.Part2(aoc.y2020.day6.Input.puzzle, 3235),
            new aoc.y2020.day7.Part1(aoc.y2020.day7.Input.puzzle, 370),
            new aoc.y2020.day7.Part2(aoc.y2020.day7.Input.puzzle, 29547),
            new aoc.y2020.day8.Part1(aoc.y2020.day8.Input.puzzle, 1859),
            new aoc.y2020.day8.Part2(aoc.y2020.day8.Input.puzzle, 1235),
            new aoc.y2020.day9.Part1(aoc.y2020.day9.Input.puzzle, 556543474),
            new aoc.y2020.day9.Part2(aoc.y2020.day9.Input.puzzle, 76096372),
            new aoc.y2020.day10.Part1(aoc.y2020.day10.Input.puzzle, 2574),
            new aoc.y2020.day10.Part2(aoc.y2020.day10.Input.puzzle, 2644613988352L),
            new aoc.y2020.day11.Part1(aoc.y2020.day11.Input.puzzle, 2166),
            new aoc.y2020.day11.Part2(aoc.y2020.day11.Input.puzzle, 1955),
            new aoc.y2020.day12.Part1(aoc.y2020.day12.Input.puzzle, 1177),
            new aoc.y2020.day12.Part2(aoc.y2020.day12.Input.puzzle, 46530),
            new aoc.y2020.day13.Part1(aoc.y2020.day13.Input.puzzle, 1895),
            new aoc.y2020.day13.Part2(aoc.y2020.day13.Input.puzzle, 840493039281088L),
            new aoc.y2020.day14.Part1(aoc.y2020.day14.Input.puzzle, 9967721333886L),
            new aoc.y2020.day14.Part2(aoc.y2020.day14.Input.puzzle, 4355897790573L),
            new aoc.y2020.day15.Part1(aoc.y2020.day15.Input.puzzle, 1238),
            new aoc.y2020.day15.Part2(aoc.y2020.day15.Input.puzzle, 3745954),
            new aoc.y2020.day16.Part1(aoc.y2020.day16.Input.puzzle, 21071),
            new aoc.y2020.day16.Part2(aoc.y2020.day16.Input.puzzle, 3429967441937L),
            new aoc.y2020.day17.Part1(aoc.y2020.day17.Input.puzzle, 448),
            new aoc.y2020.day17.Part2(aoc.y2020.day17.Input.puzzle, 2400),
            new aoc.y2020.day18.Part1(aoc.y2020.day18.Input.puzzle, 24650385570008L),
            new aoc.y2020.day18.Part2(aoc.y2020.day18.Input.puzzle, 158183007916215L),
            new aoc.y2020.day19.Part1(aoc.y2020.day19.Input.puzzle, 162),
            new aoc.y2020.day19.Part2(aoc.y2020.day19.Input.puzzle, 267),
            new aoc.y2020.day20.Part1(aoc.y2020.day20.Input.puzzle, 13224049461431L),
            new aoc.y2020.day20.Part2(aoc.y2020.day20.Input.puzzle, 2231),
            new aoc.y2020.day21.Part1(aoc.y2020.day21.Input.puzzle, 2412),
            new aoc.y2020.day21.Part2(aoc.y2020.day21.Input.puzzle,
                    "mfp,mgvfmvp,nhdjth,hcdchl,dvkbjh,dcvrf,bcjz,mhnrqp"),
            new aoc.y2020.day22.Part1(aoc.y2020.day22.Input.puzzle, 33694),
            new aoc.y2020.day22.Part2(aoc.y2020.day22.Input.puzzle, 31835),
            new aoc.y2020.day23.Part1(aoc.y2020.day23.Input.puzzle, 82934675),
            new aoc.y2020.day23.Part2(aoc.y2020.day23.Input.puzzle, 474600314018L),
            new aoc.y2020.day24.Part1(aoc.y2020.day24.Input.puzzle, 317),
            new aoc.y2020.day24.Part2(aoc.y2020.day24.Input.puzzle, 3804),
            new aoc.y2020.day25.Part1(aoc.y2020.day25.Input.puzzle, 19414467) };

    public static void main(String[] args) {
        var runner = new Runner();
        runner.runAll(allDays);
    }
}
