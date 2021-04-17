package y2020.day6;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public class Part2 extends Problem<Long> {
    private String[][] input;

    public Part2(String[][] input, long expected) {
        super(expected);
        this.input = input;
    }

    private Map<Character, Integer> questionCounts(String[] group) {
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
        int count = 0;

        for (var numAnswered : counts.values()) {
            if (numAnswered == size) {
                count += 1;
            }
        }

        return count;
    }

    public Long run() {
        long sum = 0;

        for (var group : input) {
            var counts = questionCounts(group);
            sum += countAnswered(counts, group.length);
        }

        return sum;
    }
}
