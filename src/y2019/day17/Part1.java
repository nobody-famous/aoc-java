package y2019.day17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import utils.Problem;
import utils.geometry.Point;
import y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
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

    public Integer run() {
        var prog = parser.parse();
        var ctrl = new Controller(prog);
        var output = ctrl.readCamera();
        var grid = Grid.fromCamera(output);
        var crosses = findIntersections(grid);

        return calibrate(crosses);
    }
}
