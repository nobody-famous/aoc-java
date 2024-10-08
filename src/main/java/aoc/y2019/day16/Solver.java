package aoc.y2019.day16;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Integer> {
    private Parser parser = new Parser();

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    protected abstract int doWork(List<Integer> nums);

    protected int apply(List<Integer> input, int element) {
        var startNdx = element - 1;
        var total = 0;
        var mult = 1;

        while (startNdx < input.size()) {
            for (var ndx = startNdx; ndx < input.size() && ndx < startNdx + element; ndx += 1) {
                total += input.get(ndx) * mult;
            }

            startNdx += (element * 2);
            mult = -mult;
        }

        return Math.abs(total % 10);
    }

    protected List<Integer> applyPattern(List<Integer> input) {
        var output = new ArrayList<Integer>();

        for (var element = 1; element <= input.size(); element += 1) {
            output.add(apply(input, element));
        }

        return output;
    }

    protected int listToInt(List<Integer> list) {
        var output = 0;

        for (var item : list) {
            output = (output * 10) + item;
        }

        return output;
    }

    @Override
    public Integer run(List<String> lines) {
        var nums = parser.parse(lines);

        return doWork(nums);
    }
}
