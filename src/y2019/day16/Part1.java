package y2019.day16;

import java.util.ArrayList;
import java.util.List;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private int apply(List<Integer> input, int element) {
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

    private List<Integer> applyPattern(List<Integer> input) {
        var output = new ArrayList<Integer>();

        for (var element = 1; element <= input.size(); element += 1) {
            output.add(apply(input, element));
        }

        return output;
    }

    private int listToInt(List<Integer> list) {
        var output = 0;

        for (var item : list) {
            output = (output * 10) + item;
        }

        return output;
    }

    public Integer run() {
        var nums = parser.parse();

        for (var loop = 0; loop < 100; loop += 1) {
            nums = applyPattern(nums);
        }

        return listToInt(nums.subList(0, 8));
    }
}
