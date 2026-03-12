package aoc.y2019.day11;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public class Part1 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var robot = new Robot(prog, Robot.COLOR_BLACK);

        robot.run();

        return robot.getPanels().size();
    }
}
