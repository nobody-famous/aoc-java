package aoc.y2019.day15;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Integer> {
    private Parser parser;

    public Part2(String fileName, int exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    public Integer run() {
        var prog = parser.parse();
        var mapper = new GridMapper(prog);
        var grid = mapper.mapGrid();
        var filler = new GridFiller(grid);

        return filler.fill(grid.getOxygen());
    }

}
