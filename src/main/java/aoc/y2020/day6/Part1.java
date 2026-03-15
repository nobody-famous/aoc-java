package aoc.y2020.day6;

import java.util.HashMap;
import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    private int countQuestions(List<String> group) {
        var seen = new HashMap<>();

        for (var questions : group) {
            for (var ch : questions.toCharArray()) {
                seen.put(ch, true);
            }
        }

        return seen.keySet().size();
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var total = 0;

        for (var group : input) {
            total += countQuestions(group);
        }

        return total;
    }
}
