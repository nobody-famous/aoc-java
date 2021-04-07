package y2020.day1;

public class Part2 extends Solver {
    public Part2(int[] input) {
        super(input, 2020);
    }

    protected int[] findCandidates(int[] input, int target) {
        for (var i = 0; i < input.length; i += 1) {
            var first = input[i];

            for (var j = i; j < input.length; j += 1) {
                var second = input[j];

                for (var k = j; k < input.length; k += 1) {
                    var third = input[k];

                    if (first + second + third == target) {
                        return new int[] { first, second, third };
                    }
                }
            }
        }

        return null;
    }
}
