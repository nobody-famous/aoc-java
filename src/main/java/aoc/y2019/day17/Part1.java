package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser = new Parser();

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private boolean isCross(HashSet<Point> scaffold, Point pt) {
        return scaffold.contains(new Point(pt.x, pt.y + 1)) && scaffold.contains(new Point(pt.x, pt.y - 1))
                && scaffold.contains(new Point(pt.x + 1, pt.y)) && scaffold.contains(new Point(pt.x - 1, pt.y));
    }

    private List<Point> findIntersections(Grid grid) {
        var crosses = new ArrayList<Point>();
        var scaffold = grid.getScaffold();

        for (var pt : scaffold) {
            if (isCross(scaffold, pt)) {
                crosses.add(pt);
            }
        }

        return crosses;
    }

    private int calibrate(List<Point> crosses) {
        var total = 0;

        for (var pt : crosses) {
            total += (pt.x * pt.y);
        }

        return total;
    }

    @Override
    public Integer run(List<String> lines) {
        var prog = parser.parse(lines);
        var ctrl = new Controller(prog);
        var output = ctrl.readCamera();
        var grid = Grid.fromCamera(output);
        var crosses = findIntersections(grid);

        return calibrate(crosses);
    }
}
