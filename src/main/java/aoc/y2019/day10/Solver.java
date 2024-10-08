package aoc.y2019.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public abstract class Solver extends Problem<Integer> {
    private Parser parser = new Parser();

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    protected abstract int doWork(List<Point> asteroids);

    @Override
    public Integer run(List<String> lines) {
        var asteroids = parser.parse(lines);

        return doWork(asteroids);
    }

    protected float calculateSlope(Point p1, Point p2) {
        var rise = (float) (p2.y - p1.y);
        var run = (float) (p2.x - p1.x);

        return run == 0 ? 0 : rise / run;
    }

    protected Map<Float, List<Point>> getSlopeMap(List<Point> asteroids, Point pt) {
        var slopes = new HashMap<Float, List<Point>>();

        for (var asteroid : asteroids) {
            var slope = calculateSlope(pt, asteroid);

            if (!slopes.containsKey(slope)) {
                slopes.put(slope, new ArrayList<Point>());
            }

            slopes.get(slope).add(asteroid);
        }

        return slopes;
    }

    protected List<List<Point>> createGroups(List<Point> asteroids, Point pt) {
        var groups = new ArrayList<List<Point>>();

        for (var count = 0; count < 4; count += 1) {
            groups.add(new ArrayList<Point>());
        }

        for (var asteroid : asteroids) {
            if (asteroid.equals(pt)) {
                continue;
            }

            if (asteroid.x >= pt.x && asteroid.y < pt.y) {
                groups.get(0).add(asteroid);
            } else if (asteroid.x > pt.x && asteroid.y >= pt.y) {
                groups.get(1).add(asteroid);
            } else if (asteroid.x <= pt.x && asteroid.y > pt.y) {
                groups.get(2).add(asteroid);
            } else {
                groups.get(3).add(asteroid);
            }
        }

        return groups;
    }

    protected int countVisible(List<Point> asteroids, Point pt) {
        var groups = createGroups(asteroids, pt);
        var total = 0;

        for (var group : groups) {
            var slopes = getSlopeMap(group, pt);
            total += slopes.size();
        }

        return total;
    }
}
