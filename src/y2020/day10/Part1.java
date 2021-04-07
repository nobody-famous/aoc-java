package y2020.day10;

import java.util.Arrays;

public class Part1 extends Solver {
    public Part1(int[] input) {
        super(input);
    }

    public long solve() {
        var adapters = addAdapters(input);
        Arrays.sort(adapters);

        var ones = 0;
        var threes = 0;

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
