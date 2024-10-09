package aoc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Runner<T extends AocProblem> {
    public interface Solver<T> {
        void solve(T prob, List<String> lines);
    }

    public void runAll(T[] all, Solver<T> solver) throws Exception {
        var total = 0L;

        for (var problem : all) {
            var start = System.currentTimeMillis();
            var lines = readLines(problem.getFileName());

            solver.solve(problem, lines);

            var diff = System.currentTimeMillis() - start;

            System.out.println(problem + " " + diff + " ms");
            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }

    private List<String> readLines(String fileName) throws Exception {
        if (fileName == null || fileName == "") {
            return new ArrayList<>();
        }

        try (var reader = new BufferedReader(new FileReader(fileName))) {
            var lines = new ArrayList<String>();
            var line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            return lines;
        }
    }
}
