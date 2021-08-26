package y2019.day3;

import java.util.List;

import utils.geometry.Point;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public int doWork(Wire[] wires, List<Point> crosses) {
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
