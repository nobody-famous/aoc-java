package aoc.y2020.day1;

public class Part1 extends Solver {
    public Part1(int[] input, long target) {
        super(input, 2020, target);
    }

    protected int[] findCandidates(int[] input, int target) {
        for (var i = 0; i < input.length; i += 1) {
            var first = input[i];

            for (var j = i; j < input.length; j += 1) {
                var second = input[j];

                if (first + second == target) {
                    return new int[] { first, second };
                }
            }
        }

        return null;
    }
}
