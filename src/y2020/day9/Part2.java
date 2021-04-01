package y2020.day9;

public class Part2 extends Solver {
    private long smallest = Integer.MAX_VALUE;
    private long largest = Integer.MIN_VALUE;

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

    public long solve(long[] input, int preambleLength) {
        var target = findWeakness(input, preambleLength);

        for (var ndx = 0; ndx < input.length; ndx += 1) {
            if (hasTargetSet(input, ndx, target)) {
                return smallest + largest;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle, 25);

        System.out.println(answer);
    }
}
