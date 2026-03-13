package aoc.y2019.day3;

import java.util.HashMap;
import java.util.List;

import aoc.utils.geometry.Line;
import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    private boolean onLine(Point pt, Line line) {
        return (line.start.x == line.end.x && line.start.x == pt.x && isBetween(pt.y, line.start.y, line.end.y))
                || (line.start.y == line.end.y && line.start.y == pt.y && isBetween(pt.x, line.start.x, line.end.x));
    }

    private HashMap<Point, Integer> crossDistances(Wire wire, List<Point> crosses) {
        var distances = new HashMap<Point, Integer>();
        var total = 0;

        for (var line : wire.lines) {
            for (var cross : crosses) {
                if (onLine(cross, line)) {
                    distances.put(cross, total + cross.manDist(line.start));
                }
            }

            total += line.start.manDist(line.end);
        }

        return distances;
    }

    protected int doWork(Wire[] wires, List<Point> crosses) {
        var distances1 = crossDistances(wires[0], crosses);
        var distances2 = crossDistances(wires[1], crosses);
        var closest = Integer.MAX_VALUE;

        for (var cross : crosses) {
            var dist = distances1.get(cross) + distances2.get(cross);

            if (dist < closest) {
                closest = dist;
            }
        }

        return closest;
    }
}
