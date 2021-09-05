package y2019.day13;

import utils.Problem;
import y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
        var arcade = new Arcade(prog);

        arcade.addQuarters(2);
        arcade.run();

        return arcade.getScore();
    }
}
