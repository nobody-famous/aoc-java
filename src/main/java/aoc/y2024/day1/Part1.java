package aoc.y2024.day1;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2024.day1.Parser.InputItem;

public class Part1 extends IntProblem {
    @Override
    public int solve(List<String> lines) {
        var items = new Parser().parse(lines);
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();

        populateLists(left, right, items);

        return calculateAnswer(left, right);
    }

    private void populateLists(List<Integer> left, List<Integer> right, List<InputItem> items) {
        for (var item : items) {
            left.add(item.left());
            right.add(item.right());
        }

        left.sort((a, b) -> a - b);
        right.sort((a, b) -> a - b);
    }

    private int calculateAnswer(List<Integer> left, List<Integer> right) {
        var answer = 0;

        for (var index = 0; index < left.size(); index += 1) {
            answer += Math.abs(left.get(index) - right.get(index));
        }

        return answer;
    }
}
