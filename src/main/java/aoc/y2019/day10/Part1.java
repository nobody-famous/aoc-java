package aoc.y2019.day10;

import java.util.List;

import aoc.utils.geometry.Point;

public class Part1 extends Solver {
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
