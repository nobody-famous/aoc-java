package aoc.y2019.day13;

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
        var arcade = new Arcade(prog);

        arcade.run();

        var screen = arcade.getScreen();

        var count = 0;
        for (var entry : screen.values()) {
            if (entry.intValue() == Arcade.TILE) {
                count += 1;
            }
        }

        return count;
    }
}
