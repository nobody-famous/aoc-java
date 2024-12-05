package aoc.y2024.day1;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var parser = new Parser();
        var items = parser.parse(lines);
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();

        for (var item : items) {
            left.add(item.left());
            right.add(item.right());
        }

        left.sort((a, b) -> a - b);
        right.sort((a, b) -> a - b);

        var total = 0;
        for (var index = 0; index < left.size(); index += 1) {
            total += Math.abs(left.get(index) - right.get(index));
        }

        return total;
    }
}
