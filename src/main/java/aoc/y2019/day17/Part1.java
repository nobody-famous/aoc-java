package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aoc.utils.AocProblem;
import aoc.utils.Grid;
import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Parser;

public class Part1 implements AocProblem<Integer> {
    private final Parser parser = new Parser();

    private boolean isCross(Set<Point> scaffold, Point pt) {
        return scaffold.contains(new Point(pt.x, pt.y + 1)) && scaffold.contains(new Point(pt.x, pt.y - 1))
                && scaffold.contains(new Point(pt.x + 1, pt.y)) && scaffold.contains(new Point(pt.x - 1, pt.y));
    }

    private List<Point> findIntersections(Set<Point> scaffold) {
        var crosses = new ArrayList<Point>();

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
    public Integer solve(List<String> lines) {
        var prog = parser.parse(lines);
        var ctrl = new Controller(prog);
        var output = ctrl.readCamera();
        var grid = Grid.parse(output);
        var scaffold = Utils.buildScaffold(grid);
        var crosses = findIntersections(scaffold);

        return calibrate(crosses);
    }
}
