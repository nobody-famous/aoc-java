package aoc.y2019.day13;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
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
