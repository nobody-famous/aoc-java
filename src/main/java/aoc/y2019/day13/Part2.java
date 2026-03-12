package aoc.y2019.day13;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public class Part2 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var arcade = new Arcade(prog);

        arcade.addQuarters(2);
        arcade.run();

        return arcade.getScore();
    }
}
