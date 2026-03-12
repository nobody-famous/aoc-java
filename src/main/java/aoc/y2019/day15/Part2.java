package aoc.y2019.day15;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public class Part2 extends IntProblem {
    private final Parser parser = new Parser();

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var mapper = new GridMapper(prog);
        var grid = mapper.mapGrid();
        var filler = new GridFiller(grid);

        return filler.fill(grid.getOxygen());
    }

}
