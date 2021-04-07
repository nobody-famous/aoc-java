package y2020.day5;

import utils.Problem;

public class Part2 implements Problem {
    private int[] input;

    public Part2(int[] input) {
        this.input = input;
    }

    public long solve() {
        var min = Long.MAX_VALUE;
        var max = Long.MIN_VALUE;
        var sum = 0L;

        for (var n : input) {
            if (n < min) {
                min = n;
            }

            if (n > max) {
                max = n;
            }

            sum += n;
        }

        var rangeSum = 0;
        for (var i = min; i <= max; i += 1) {
            rangeSum += i;
        }

        var answer = rangeSum - sum;

        return answer;
    }
}
