package aoc.y2019.day24;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.Problem;

public class Part2 extends Problem<Integer> {
    private Parser parser;
    private Map<Integer, Grid> grids = new HashMap<>();

    public Part2(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    @Override
    public Integer run() {
        var grid = parser.parse();

        grids.put(-1, new Grid());
        grids.put(0, grid);
        grids.put(1, new Grid());

        return 0;
    }
}
