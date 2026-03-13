package aoc.y2019.day13;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part2 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var arcade = new Arcade(prog);

        arcade.addQuarters(2);
        arcade.run();

        return arcade.getScore();
    }
}
