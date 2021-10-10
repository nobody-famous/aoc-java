package y2019.day16;

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

    protected int doWork(List<Integer> nums) {
        var offset = listToInt(nums.subList(0, 7));

        nums = createSignal(nums);

        for (var loop = 0; loop < 100; loop += 1) {
            nums = applyPattern(nums);
        }

        System.out.println("Length " + nums.size());
        System.out.println("Offset " + offset);
        return 0;
    }
}
