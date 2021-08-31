import utils.AocProblem;
import utils.Runner;

public class Runner2019 extends Runner {
    public static AocProblem[] allDays = new AocProblem[] { new y2019.day1.Part1("input/2019/day1/puzzle.txt", 3279287),
            new y2019.day1.Part2("input/2019/day1/puzzle.txt", 4916076),
            new y2019.day2.Part1("input/2019/day2/puzzle.txt", 3101844),
            new y2019.day2.Part2("input/2019/day2/puzzle.txt", 8478),
            new y2019.day3.Part1("input/2019/day3/puzzle.txt", 529),
            new y2019.day3.Part2("input/2019/day3/puzzle.txt", 20386),
            new y2019.day4.Part1("input/2019/day4/puzzle.txt", 511),
            new y2019.day4.Part2("input/2019/day4/puzzle.txt", 316),
            new y2019.day5.Part1("input/2019/day5/puzzle.txt", 13294380),
            new y2019.day5.Part2("input/2019/day5/puzzle.txt", 11460760),
            new y2019.day6.Part1("input/2019/day6/puzzle.txt", 162816),
            new y2019.day6.Part2("input/2019/day6/puzzle.txt", 304),
            new y2019.day7.Part1("input/2019/day7/puzzle.txt", 21760),
            new y2019.day7.Part2("input/2019/day7/puzzle.txt", 69816958),
            new y2019.day8.Part1("input/2019/day8/puzzle.txt", 2356),
            new y2019.day8.Part2("input/2019/day8/puzzle.txt", "PZEKB"),
            new y2019.day9.Part1("input/2019/day9/puzzle.txt", 2870072642L),
            new y2019.day9.Part2("input/2019/day9/puzzle.txt", 58534L),
            new y2019.day10.Part1("input/2019/day10/puzzle.txt", 347) };

    public static void main(String[] args) {
        var runner = new Runner2018();

        // var allDays = new AocProblem[] { new y2019.day10.Part1("input/2019/day10/puzzle.txt", 347) };

        runner.runAll(allDays);
    }
}
