package y2019.day10;

import java.util.Arrays;
import java.util.List;

import utils.geometry.Point;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private List<List<Point>> sortSlopes(List<Point> asteroids, Point pt) {
        var groups = createGroups(asteroids, pt);

        for (var group : groups) {
            var slopes = getSlopeMap(group, pt);
            var keys = slopes.keySet().toArray();

            Arrays.sort(keys);

            System.out.println();
            for (var key : keys) {
                System.out.print(" " + key);
            }
            System.out.println();
        }

        return null;
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

        return 0;
    }
}
