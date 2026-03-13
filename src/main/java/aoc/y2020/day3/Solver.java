package aoc.y2020.day3;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
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

    protected char[][] parseLines(List<String> lines) {
        var result = new char[lines.size()][];

        for (var index = 0; index < lines.size(); index++) {
            result[index] = lines.get(index).toCharArray();
        }

        return result;
    }
}
