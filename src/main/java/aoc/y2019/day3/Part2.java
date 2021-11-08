package aoc.y2019.day3;

import java.util.HashMap;
import java.util.List;

import aoc.utils.geometry.Line;
import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private boolean onLine(Point pt, Line line) {
        return (line.start.x == line.end.x && line.start.x == pt.x && isBetween(pt.y, line.start.y, line.end.y))
                || (line.start.y == line.end.y && line.start.y == pt.y && isBetween(pt.x, line.start.x, line.end.x));
    }

    private HashMap<Point, Integer> crossDists(Wire wire, List<Point> crosses) {
        var dists = new HashMap<Point, Integer>();
        var total = 0;

        for (var line : wire.lines) {
            for (var cross : crosses) {
                if (onLine(cross, line)) {
                    dists.put(cross, total + cross.manDist(line.start));
                }
            }

            total += line.start.manDist(line.end);
        }

        return dists;
    }

    protected int doWork(Wire[] wires, List<Point> crosses) {
        var dists1 = crossDists(wires[0], crosses);
        var dists2 = crossDists(wires[1], crosses);
        var closest = Integer.MAX_VALUE;

        for (var cross : crosses) {
            var dist = dists1.get(cross) + dists2.get(cross);

            if (dist < closest) {
                closest = dist;
            }
        }

        return closest;
    }
}
