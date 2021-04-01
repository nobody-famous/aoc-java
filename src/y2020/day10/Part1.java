package y2020.day10;

import java.util.Arrays;

public class Part1 extends Solver {
    public long solve(int[] input) {
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

        return ones * threes;
    }

    public static void main(String[] args) {
        var solver = new Part1();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
