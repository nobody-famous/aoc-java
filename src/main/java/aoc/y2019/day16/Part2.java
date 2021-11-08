package aoc.y2019.day16;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private List<Integer> createSignal(List<Integer> input) {
        var output = new ArrayList<Integer>();

        for (var loop = 0; loop < 10_000; loop += 1) {
            output.addAll(input);
        }

        return output;
    }

    private void applyToOffset(List<Integer> nums, int offset) {
        var total = 0;

        for (var ndx = nums.size() - 1; ndx >= offset; ndx -= 1) {
            total += nums.get(ndx);
            nums.set(ndx, Math.abs(total % 10));
        }
    }

    protected int doWork(List<Integer> nums) {
        var offset = listToInt(nums.subList(0, 7));

        nums = createSignal(nums);

        for (var loop = 0; loop < 100; loop += 1) {
            applyToOffset(nums, offset);
        }

        return listToInt(nums.subList(offset, offset + 8));
    }
}
