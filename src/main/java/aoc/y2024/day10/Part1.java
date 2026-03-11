package aoc.y2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.utils.Grid;
import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    public Part1(String filename, int expected) {
        super(filename, expected);
    }

    private void findTrailEnds(Grid grid, Set<Point> heads, Set<Point> tails) {
        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                if (grid.get(row, col) == '0') {
                    heads.add(new Point(col, row));
                } else if (grid.get(row, col) == '9') {
                    tails.add(new Point(col, row));
                }
            }
        }
    }

    @Override
    public Integer run(List<String> lines) {
        var grid = Grid.parse(lines);
        var trailHeads = new HashSet<Point>();
        var trailTails = new HashSet<Point>();

        findTrailEnds(grid, trailHeads, trailTails);

        System.out.println("HEADS " + trailHeads);
        System.out.println("TAILS " + trailTails);

        return 0;
    }
}
