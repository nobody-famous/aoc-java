package aoc.y2019.day16;

import java.util.List;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public int doWork(List<Integer> nums) {
        for (var loop = 0; loop < 100; loop += 1) {
            nums = applyPattern(nums);
        }

        return listToInt(nums.subList(0, 8));
    }
}
