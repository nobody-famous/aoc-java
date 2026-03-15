package aoc.y2020.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Integer> {
    private Map<Character, Integer> questionCounts(List<String> group) {
        var counts = new HashMap<Character, Integer>();

        for (var questions : group) {
            for (var ch : questions.toCharArray()) {
                var value = 0;

                if (counts.containsKey(ch)) {
                    value = counts.get(ch);
                }

                counts.put(ch, value + 1);
            }
        }

        return counts;
    }

    private int countAnswered(Map<Character, Integer> counts, int size) {
        return Math.toIntExact(counts.values().stream().filter(n -> n == size).count());
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var sum = 0;

        for (var group : input) {
            var counts = questionCounts(group);
            sum += countAnswered(counts, group.size());
        }

        return sum;
    }
}
