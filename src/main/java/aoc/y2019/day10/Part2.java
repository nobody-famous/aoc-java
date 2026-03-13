package aoc.y2019.day10;

import aoc.utils.geometry.Point;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Solver {
    private List<List<Point>> sortSlopes(List<Point> asteroids, Point pt) {
        var groups = createGroups(asteroids, pt);
        var sorted = new ArrayList<List<Point>>();

        for (var group : groups) {
            var slopes = getSlopeMap(group, pt);
            sorted.addAll(slopes.values());
        }

        return sorted;
    }

    private Point bestLocation(List<Point> asteroids) {
        var most = 0;
        Point best = null;

        for (var pt : asteroids) {
            var count = countVisible(asteroids, pt);

            if (count > most) {
                most = count;
                best = pt;
            }
        }

        return best;
    }

    protected int doWork(List<Point> asteroids) {
        var pt = bestLocation(asteroids);
        var sorted = sortSlopes(asteroids, pt);

        var count = 0;
        var ndx = 0;
        Point lastPt = null;

        while (count < 200) {
            var item = sorted.get(ndx);

            if (!item.isEmpty()) {
                lastPt = item.removeFirst();
                count += 1;
            }

            ndx = (ndx + 1) % sorted.size();
        }

        return (lastPt.x * 100) + lastPt.y;
    }
}
