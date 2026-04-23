package aoc.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import aoc.utils.AocProblem;

public record Solver<T>(AocProblem<T> problem, String file, T expected) {
    @Override
    public final String toString() {
        return problem.getClass().getCanonicalName();
    }

    public String run(Path baseDir) throws Exception {
        try {
            var filePath = baseDir.resolve(file).normalize();
            var lines = readLines(filePath.toString());
            var result = problem.solve(lines);

            return (expected.equals(result))
                    ? "[OK]"
                    : "[Failed: Expected " + expected + ", got " + result + "]";
        } catch (Exception ex) {
            return "[Failed: " + ex.getMessage() + "]";
        }
    }

    private List<String> readLines(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty()) {
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
