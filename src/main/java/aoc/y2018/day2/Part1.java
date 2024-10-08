package aoc.y2018.day2;

import java.util.List;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int[] letterCounts(String str) {
        var counts = new int[26];

        for (var ch : str.toCharArray()) {
            var ndx = ch - 'a';
            counts[ndx] += 1;
        }

        return counts;
    }

    private void countTwosThrees(int[] counts, int[] twosThrees) {
        var hasTwo = false;
        var hasThree = false;

        for (var count : counts) {
            if (count == 2) {
                hasTwo = true;
            } else if (count == 3) {
                hasThree = true;
            }
        }

        if (hasTwo) {
            twosThrees[0] += 1;
        }

        if (hasThree) {
            twosThrees[1] += 1;
        }
    }

    @Override
    public Integer run(List<String> lines) {
        var input = parser.parse(lines);
        var twosThrees = new int[2];

        for (var str : input) {
            var counts = letterCounts(str);

            countTwosThrees(counts, twosThrees);
        }

        return twosThrees[0] * twosThrees[1];
    }
}
