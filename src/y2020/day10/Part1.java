package y2020.day10;

import java.util.Arrays;

public class Part1 extends Solver {
    public Part1(int[] input, long expected) {
        super(input, expected);
    }

    public Long run() {
        var adapters = addAdapters(input);
        Arrays.sort(adapters);

        var ones = 0L;
        var threes = 0L;

        for (var ndx = 1; ndx < adapters.length; ndx += 1) {
            var diff = adapters[ndx] - adapters[ndx - 1];

            if (diff == 1) {
                ones += 1;
            } else if (diff == 3) {
                threes += 1;
            }
        }

        var answer = ones * threes;

        return answer;
    }
}
