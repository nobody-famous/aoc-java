package aoc.y2020.day3;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected char[][] input;

    protected Solver(char[][] input, long expected) {
        super(expected);
        this.input = input;
    }

    protected long countTrees(char[][] input, int right, int down) {
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
