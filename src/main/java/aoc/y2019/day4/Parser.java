package aoc.y2019.day4;

import java.util.List;

public class Parser extends aoc.utils.Parser<int[][]> {
    private int[] toIntArray(String str) {
        var arr = new int[str.length()];

        for (var ndx = 0; ndx < str.length(); ndx += 1) {
            arr[ndx] = (str.charAt(ndx) - '0');
        }

        return arr;
    }

    @Override
    public int[][] parse(List<String> lines) {
        try {
            var parts = lines.getFirst().split("-");
            var numbers = new int[2][];

            numbers[0] = toIntArray(parts[0]);
            numbers[1] = toIntArray(parts[1]);

            return numbers;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
