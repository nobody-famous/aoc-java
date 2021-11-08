package aoc.y2019.day17;

import java.util.HashSet;
import java.util.List;

import aoc.utils.geometry.Point;

public class Grid {
    private HashSet<Point> scaffold;
    private Point robot;
    private char robotDir;

    public Grid() {
        this.scaffold = new HashSet<>();
    }

    public static Grid fromCamera(List<String> output) {
        var grid = new Grid();

        for (var y = 0; y < output.size(); y += 1) {
            var row = output.get(y);

            for (var x = 0; x < row.length(); x += 1) {
                var ch = row.charAt(x);

                switch (ch) {
                    case '#':
                        grid.scaffold.add(new Point(x, y));
                        break;
                    case '^':
                    case 'v':
                    case '<':
                    case '>':
                        grid.scaffold.add(new Point(x, y));
                        grid.robot = new Point(x, y);
                        grid.robotDir = ch;
                        break;
                }
            }
        }

        return grid;
    }

    public Point getRobot() {
        return robot;
    }

    public void setRobot(Point pt) {
        robot = pt;
    }

    public char getRobotDir() {
        return robotDir;
    }

    public void setRobotDir(char dir) {
        robotDir = dir;
    }

    public HashSet<Point> getScaffold() {
        return scaffold;
    }
}
