package aoc.y2019.day16;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Solver {
    private List<Integer> createSignal(List<Integer> input) {
        var output = new ArrayList<Integer>();

        for (var loop = 0; loop < 10_000; loop += 1) {
            output.addAll(input);
        }

        return output;
    }

    private void applyToOffset(List<Integer> numbers, int offset) {
        var total = 0;

        for (var ndx = numbers.size() - 1; ndx >= offset; ndx -= 1) {
            total += numbers.get(ndx);
            numbers.set(ndx, Math.abs(total % 10));
        }
    }

    protected int doWork(List<Integer> numbers) {
        var offset = listToInt(numbers.subList(0, 7));

        numbers = createSignal(numbers);

        for (var loop = 0; loop < 100; loop += 1) {
            applyToOffset(numbers, offset);
        }

        return listToInt(numbers.subList(offset, offset + 8));
    }
}
