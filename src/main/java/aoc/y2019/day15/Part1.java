package aoc.y2019.day15;

import java.util.List;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var prog = parser.parse(lines);
        var mapper = new GridMapper(prog);
        var grid = mapper.mapGrid();
        var finder = new PathFinder(grid);

        return finder.findMinDist();
    }
}
