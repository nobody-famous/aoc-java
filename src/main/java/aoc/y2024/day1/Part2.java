package aoc.y2024.day1;

import java.util.HashMap;
import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2024.day1.Parser.InputItem;

public class Part2 extends IntProblem {
    @Override
    public int solve(List<String> lines) {
        var items = new Parser().parse(lines);
        var scores = new HashMap<Integer, Integer>();

        populateScores(scores, items);

        return calculateAnswer(scores, items);
    }

    private void populateScores(HashMap<Integer, Integer> scores, List<InputItem> items) {
        for (var item : items) {
            var right = item.right();

            if (!scores.containsKey(right)) {
                scores.put(right, right);
            } else {
                scores.put(right, scores.get(right) + right);
            }
        }
    }

    private int calculateAnswer(HashMap<Integer, Integer> scores, List<InputItem> items) {
        var answer = 0;
        for (var item : items) {
            var left = item.left();

            answer += scores.containsKey(left)
                    ? scores.get(left)
                    : 0;
        }

        return answer;
    }
}
