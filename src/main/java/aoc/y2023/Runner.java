package aoc.y2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Runner extends aoc.utils.Runner<AocProblem2023> {
    public static AocProblem2023[] allDays = new AocProblem2023[] {
            new aoc.y2023.day1.Part1("input/2023/day1/puzzle.txt", 437),
    };

    public static Connection connectDB() throws Exception {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var props = new Properties();

        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        return DriverManager.getConnection(url, props);
    }

    public static void main(String[] args) throws Exception {
        var runner = new Runner();

        try (var conn = connectDB()) {
            runner.runAll(allDays, (prob, lines) -> prob.solve(conn, lines));
        }
    }
}
