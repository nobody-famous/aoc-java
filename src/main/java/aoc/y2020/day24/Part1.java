package aoc.y2020.day24;

import java.util.List;

public class Part1 extends Solver {
    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);

        for (var dirs : input) {
            processMoves(dirs);
        }

        var sum = 0;
        for (var color : tiles.values()) {
            if (color == Color.BLACK) {
                sum += 1;
            }
        }

        return sum;
    }
}
