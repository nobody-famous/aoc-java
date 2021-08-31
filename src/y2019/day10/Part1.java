package y2019.day10;

import java.util.List;

import utils.geometry.Point;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    protected int doWork(List<Point> asteroids) {
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
