package aoc.y2024.day1;

import java.util.HashMap;
import java.util.List;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var parser = new Parser();
        var items = parser.parse(lines);
        var score = new HashMap<Integer, Integer>();

        for (var item : items) {
            var right = item.right();

            if (!score.containsKey(right)) {
                score.put(right, right);
            } else {
                score.put(right, score.get(right) + right);
            }
        }

        return items.stream().map(v -> score.containsKey(v.left()) ? score.get(v.left()) : 0).mapToInt(Integer::intValue).sum();
    }
}
