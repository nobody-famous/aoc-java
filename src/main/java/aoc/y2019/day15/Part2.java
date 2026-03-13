package aoc.y2019.day15;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Parser;

public class Part2 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    @Override
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var mapper = new GridMapper(prog);
        var grid = mapper.mapGrid();
        var filler = new GridFiller(grid);

        return filler.fill(grid.getOxygen());
    }

}
