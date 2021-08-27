package y2019.day4;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private void findFirstNum(int[] num) {
        var ndx = 1;

        while (num[ndx - 1] <= num[ndx]) {
            ndx += 1;

            if (ndx == num.length) {
                return;
            }
        }

        var value = num[ndx - 1];
        while (ndx < num.length) {
            num[ndx] = value;
            ndx += 1;
        }
    }

    private void incNum(int[] num) {
        for (var ndx = num.length - 1; ndx >= 0; ndx -= 1) {
            num[ndx] += 1;

            if (num[ndx] < 10) {
                break;
            }

            num[ndx] = 0;
        }

        findFirstNum(num);
    }

    private boolean isLessThan(int[] num1, int[] num2) {
        for (var ndx = 0; ndx < num1.length; ndx += 1) {
            if (num1[ndx] > num2[ndx]) {
                return false;
            } else if (num1[ndx] < num2[ndx]) {
                return true;
            }
        }

        return true;
    }

    private boolean isValid(int[] num) {
        for (var ndx = 1; ndx < num.length; ndx += 1) {
            if (num[ndx] == num[ndx - 1]) {
                return true;
            }
        }

        return false;
    }

    public Integer run() {
        var nums = parser.parse();
        var total = 0;

        findFirstNum(nums[0]);

        while (isLessThan(nums[0], nums[1])) {
            if (isValid(nums[0])) {
                total += 1;
            }

            incNum(nums[0]);
        }

        return total;
    }
}
