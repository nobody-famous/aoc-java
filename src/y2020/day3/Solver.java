package y2020.day3;

public abstract class Solver {
    protected abstract long solve(char[][] input);

    protected int countTrees(char[][] input, int right, int down) {
        var row = 0;
        var col = 0;
        var trees = 0;

        while (row < input.length) {
            if (input[row][col] == '#') {
                trees += 1;
            }

            col = (col + right) % input[row].length;
            row += down;
        }

        return trees;
    }
}
