package y2019.day18;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Integer run() {
        var grid = parser.parse();

        System.out.println(grid.getEntrance());

        return 0;
    }
}
