package y2019.day15;

import utils.Problem;
import y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    public Integer run() {
        var prog = parser.parse();
        var droid = new RepairDroid(prog);
        var mapper = new GridMapper(droid);
        var grid = mapper.mapGrid();

        System.out.println(grid);

        return 254;
    }
}
