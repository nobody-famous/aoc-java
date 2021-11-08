package aoc.y2020.day9;

public class Part2 extends Solver {
    private long smallest = Integer.MAX_VALUE;
    private long largest = Integer.MIN_VALUE;

    public Part2(long[] input, long expected) {
        super(input, 25, expected);
    }

    private boolean hasTargetSet(long[] input, int ndx, long target) {
        var sum = 0L;

        smallest = Long.MAX_VALUE;
        largest = Long.MIN_VALUE;

        while (sum < target) {
            var value = input[ndx];

            if (value < smallest) {
                smallest = value;
            }

            if (value > largest) {
                largest = value;
            }

            sum += input[ndx];

            if (sum == target) {
                return true;
            }

            ndx += 1;
        }

        return false;
    }

    public Long run() {
        var target = findWeakness(input, preambleLength);
        var answer = 0L;

        for (var ndx = 0; ndx < input.length; ndx += 1) {
            if (hasTargetSet(input, ndx, target)) {
                answer = smallest + largest;
                break;
            }
        }

        return answer;
    }
}
