package aoc.y2019.day13;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public class Part1 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var arcade = new Arcade(prog);

        arcade.run();

        var screen = arcade.getScreen();

        var count = 0;
        for (var entry : screen.values()) {
            if (entry == Arcade.TILE) {
                count += 1;
            }
        }

        return count;
    }
}
