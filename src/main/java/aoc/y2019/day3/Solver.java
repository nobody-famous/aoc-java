package aoc.y2019.day3;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.Problem;
import aoc.utils.geometry.Line;
import aoc.utils.geometry.Point;

public abstract class Solver extends Problem<Integer> {
    protected Parser parser;

    public Solver(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    protected abstract int doWork(Wire[] wires, List<Point> crosses);

    protected boolean isBetween(int value, int start, int end) {
        return (start < end) ? value >= start && value <= end : value >= end && value <= start;
    }

    protected boolean linesCross(Line vert, Line horiz) {
        return isBetween(vert.start.x, horiz.start.x, horiz.end.x)
                && isBetween(horiz.start.y, vert.start.y, vert.end.y);
    }

    protected Point crossPoint(Line line1, Line line2) {
        if (line1.start.x == line1.end.x && line2.start.y == line2.end.y) {
            return linesCross(line1, line2) ? new Point(line1.start.x, line2.start.y) : null;
        } else if (line2.start.x == line2.end.x && line1.start.y == line1.end.y) {
            return linesCross(line2, line1) ? new Point(line2.start.x, line1.start.y) : null;
        }

        return null;
    }

    protected List<Point> findCrosses(Wire[] wires) {
        var crosses = new ArrayList<Point>();

        for (var line1 : wires[0].lines) {
            for (var line2 : wires[1].lines) {
                var pt = crossPoint(line1, line2);

                if (pt != null) {
                    crosses.add(pt);
                }
            }
        }

        return crosses;
    }

    public Integer run() {
        var wires = parser.parse();
        var crosses = findCrosses(wires);

        return doWork(wires, crosses);
    }
}
