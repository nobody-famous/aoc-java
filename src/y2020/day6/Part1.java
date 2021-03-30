package y2020.day6;

import java.util.HashMap;

public class Part1 {
    private int countQuestions(String[] group) {
        var seen = new HashMap<>();

        for (var questions : group) {
            for (var ch : questions.toCharArray()) {
                seen.put(ch, true);
            }
        }

        return seen.keySet().size();
    }

    public long solve(String[][] input) {
        long total = 0;

        for (var group : input) {
            total += countQuestions(group);
        }

        return total;
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
