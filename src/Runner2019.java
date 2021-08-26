import utils.AocProblem;
import utils.Runner;

public class Runner2019 extends Runner {
    public static AocProblem[] allDays = new AocProblem[] { new y2019.day1.Part1("input/2019/day1/puzzle.txt", 3279287),
            new y2019.day1.Part2("input/2019/day1/puzzle.txt", 4916076),
            new y2019.day2.Part1("input/2019/day2/puzzle.txt", 3101844),
            new y2019.day2.Part2("input/2019/day2/puzzle.txt", 8478) };

    public static void main(String[] args) {
        var runner = new Runner2018();

        var allDays = new AocProblem[] { new y2019.day3.Part1("input/2019/day3/puzzle.txt", 529) };

        runner.runAll(allDays);
    }
}
