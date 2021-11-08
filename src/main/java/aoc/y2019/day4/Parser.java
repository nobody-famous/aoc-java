package aoc.y2019.day4;

public class Parser extends aoc.utils.Parser<int[][]> {
    public Parser(String fileName) {
        super(fileName);
    }

    private int[] toIntArray(String str) {
        var arr = new int[str.length()];

        for (var ndx = 0; ndx < str.length(); ndx += 1) {
            arr[ndx] = (str.charAt(ndx) - '0');
        }

        return arr;
    }

    public int[][] parse() {
        try {
            var lines = readLines();
            var parts = lines.get(0).split("-");
            var nums = new int[2][];

            nums[0] = toIntArray(parts[0]);
            nums[1] = toIntArray(parts[1]);

            return nums;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
