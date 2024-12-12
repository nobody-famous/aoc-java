package aoc.y2024.day4;

import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public abstract class Solver extends Problem<Integer> {
    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    abstract char getTargetChar();

    abstract int countMatches(Grid grid, Point pt);

    @Override
    public Integer run(List<String> lines) {
        var grid = new Parser().parse(lines);

        var startPoints = grid.findAll(getTargetChar());
        var answer = 0;

        for (var pt : startPoints) {
            answer += countMatches(grid, pt);
        }

        return answer;
    }
}
