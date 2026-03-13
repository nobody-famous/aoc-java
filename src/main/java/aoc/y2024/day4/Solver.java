package aoc.y2024.day4;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.geometry.Point;

public abstract class Solver implements AocProblem<Integer> {
    abstract char getTargetChar();

    abstract int countMatches(Grid grid, Point pt);

    @Override
    public Integer solve(List<String> lines) {
        var grid = new Parser().parse(lines);

        var startPoints = grid.findAll(getTargetChar());
        var answer = 0;

        for (var pt : startPoints) {
            answer += countMatches(grid, pt);
        }

        return answer;
    }
}
