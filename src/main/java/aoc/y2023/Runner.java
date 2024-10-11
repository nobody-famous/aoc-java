package aoc.y2023;

public class Runner extends aoc.utils.Runner<AocProblem2023> {
    public static AocProblem2023[] allDays = new AocProblem2023[] {
            new aoc.y2023.day1.Part1("input/2023/day1/puzzle.txt", 437),
    };

    public static void main(String[] args) throws Exception {
        var runner = new Runner();

        try (var conn = Helpers.connectDB()) {
            runner.runAll(allDays, (prob, lines) -> prob.solve(conn, lines));
        }
    }
}
