package aoc.y2019.day11;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part1 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var robot = new Robot(prog, Robot.COLOR_BLACK);

        robot.run();

        return robot.getPanels().size();
    }
}
