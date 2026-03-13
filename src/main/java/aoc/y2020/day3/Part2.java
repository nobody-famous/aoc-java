package aoc.y2020.day3;

import java.util.List;

public class Part2 extends Solver {
    @Override
    public Long solve(List<String> lines) {
        var input = parseLines(lines);
        var slopes = new int[][]{ { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 1, 2 } };
        var answer = 0L;

        for (var slope : slopes) {
            var trees = countTrees(input, slope[0], slope[1]);

            answer = (answer == 0) ? trees : answer * trees;
        }

        return answer;
    }
}
