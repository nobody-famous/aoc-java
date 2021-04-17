package y2020.day3;

public class Part2 extends Solver {
    public Part2(char[][] input, long expected) {
        super(input, expected);
    }

    public Long run() {
        int[][] slopes = new int[][] { { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 1, 2 } };
        long answer = 0;

        for (var slope : slopes) {
            var trees = countTrees(input, slope[0], slope[1]);

            answer = (answer == 0) ? trees : answer * trees;
        }

        return answer;
    }
}
