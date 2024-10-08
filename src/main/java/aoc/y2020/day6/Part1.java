package aoc.y2020.day6;

import java.util.HashMap;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private String[][] input;

    public Part1(String[][] input, long expected) {
        super(expected);
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

    public Long run() {
        long total = 0;

        for (var group : input) {
            total += countQuestions(group);
        }

        return total;
    }
}
