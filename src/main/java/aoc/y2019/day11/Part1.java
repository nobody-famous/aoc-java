package aoc.y2019.day11;

import java.util.List;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var prog = parser.parse(lines);
        var robot = new Robot(prog, Robot.COLOR_BLACK);

        robot.run();

        return robot.getPanels().size();
    }
}
