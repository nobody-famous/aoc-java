import utils.AocProblem;
import utils.Runner;

public class Runner2018 extends Runner {
    public static AocProblem[] allDays = new AocProblem[] { new y2018.day1.Part1("input/2018/day1/puzzle.txt", 437L) };

    public static void main(String[] args) {
        var runner = new Runner2018();

        var allDays = new AocProblem[] { new y2018.day1.Part1("input/2018/day1/puzzle.txt", 437L) };
        runner.runAll(allDays);
    }
}
