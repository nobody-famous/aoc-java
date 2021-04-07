package y2020.day6;

import java.util.HashMap;

import utils.Problem;

public class Part1 implements Problem {
    private String[][] input;

    public Part1(String[][] input) {
        this.input = input;
    }

    private int countQuestions(String[] group) {
        var seen = new HashMap<>();

        for (var questions : group) {
            for (var ch : questions.toCharArray()) {
                seen.put(ch, true);
            }
        }

        return seen.keySet().size();
    }

    public long solve() {
        long total = 0;

        for (var group : input) {
            total += countQuestions(group);
        }

        return total;
    }
}
