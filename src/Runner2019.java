import utils.AocProblem;
import utils.Runner;

public class Runner2019 extends Runner {
    public static AocProblem[] allDays = new AocProblem[] {};

    public static void main(String[] args) {
        var runner = new Runner2018();

        var allDays = new AocProblem[] { new y2019.day1.Part1("input/2019/day1/puzzle.txt", 3279287) };

        runner.runAll(allDays);
    }
}
