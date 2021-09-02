package y2019.day11;

import utils.Problem;
import y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var prog = parser.parse();
        var robot = new Robot(prog, Robot.COLOR_BLACK);

        robot.run();

        return robot.numPanels();
    }
}
