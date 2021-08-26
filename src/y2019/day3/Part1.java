package y2019.day3;

import java.util.ArrayList;
import java.util.List;

import utils.Problem;
import utils.geometry.Line;
import utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private boolean isBetween(int value, int start, int end) {
        return (start < end) ? value >= start && value <= end : value >= end && value <= start;
    }

    private boolean linesCross(Line vert, Line horiz) {
        return isBetween(vert.start.x, horiz.start.x, horiz.end.x)
                && isBetween(horiz.start.y, vert.start.y, vert.end.y);
    }

    private Point crossPoint(Line line1, Line line2) {
        if (line1.start.x == line1.end.x && line2.start.y == line2.end.y) {
            return linesCross(line1, line2) ? new Point(line1.start.x, line2.start.y) : null;
        } else if (line2.start.x == line2.end.x && line1.start.y == line1.end.y) {
            return linesCross(line2, line1) ? new Point(line2.start.x, line1.start.y) : null;
        }

        return null;
    }

    private List<Point> findCrosses(Wire[] wires) {
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
        var closest = Integer.MAX_VALUE;
        var origin = new Point(0, 0);

        for (var cross : crosses) {
            var dist = cross.manDist(origin);

            if (dist != 0 && dist < closest) {
                closest = dist;
            }
        }

        return closest;
    }
}
