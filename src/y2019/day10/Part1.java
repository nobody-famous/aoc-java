package y2019.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Problem;
import utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private float calculateSlope(Point p1, Point p2) {
        var rise = (float) (p2.y - p1.y);
        var run = (float) (p2.x - p1.x);

        return run == 0 ? 0 : rise / run;
    }

    private Map<Float, Integer> getSlopeMap(List<Point> asteroids, Point pt) {
        var slopes = new HashMap<Float, Integer>();

        for (var asteroid : asteroids) {
            var slope = calculateSlope(pt, asteroid);

            if (!slopes.containsKey(slope)) {
                slopes.put(slope, 0);
            }

            slopes.put(slope, slopes.get(slope) + 1);
        }

        return slopes;
    }

    private List<List<Point>> createGroups(List<Point> asteroids, Point pt) {
        var groups = new ArrayList<List<Point>>();

        for (var count = 0; count < 4; count += 1) {
            groups.add(new ArrayList<Point>());
        }

        for (var asteroid : asteroids) {
            if (asteroid.equals(pt)) {
                continue;
            }

            if (asteroid.x >= pt.x && asteroid.y > pt.y) {
                groups.get(0).add(asteroid);
            } else if (asteroid.x > pt.x && asteroid.y <= pt.y) {
                groups.get(1).add(asteroid);
            } else if (asteroid.x <= pt.x && asteroid.y < pt.y) {
                groups.get(2).add(asteroid);
            } else {
                groups.get(3).add(asteroid);
            }
        }

        return groups;
    }

    private int countVisible(List<Point> asteroids, Point pt) {
        var groups = createGroups(asteroids, pt);
        var total = 0;

        for (var group : groups) {
            var slopes = getSlopeMap(group, pt);
            total += slopes.size();
        }

        return total;
    }

    public Integer run() {
        var asteroids = parser.parse();
        var most = 0;

        for (var pt : asteroids) {
            var count = countVisible(asteroids, pt);

            if (count > most) {
                most = count;
            }
        }

        return most;
    }
}
