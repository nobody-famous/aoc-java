package aoc.y2019.day11;

import java.util.List;
import java.util.Map;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<String> {
    private Parser parser = new Parser();

    public Part2(String fileName, String exp) {
        super(fileName, exp);
    }

    private Point findMin(Map<Point, Integer> panels) {
        var minX = Integer.MAX_VALUE;
        var minY = Integer.MAX_VALUE;

        for (var pt : panels.keySet()) {
            if (pt.x < minX) {
                minX = pt.x;
            }

            if (pt.y < minY) {
                minY = pt.y;
            }
        }

        return new Point(minX, minY);
    }

    private Point findMax(Map<Point, Integer> panels) {
        var maxX = Integer.MIN_VALUE;
        var maxY = Integer.MIN_VALUE;

        for (var pt : panels.keySet()) {
            if (pt.x > maxX) {
                maxX = pt.x;
            }

            if (pt.y > maxY) {
                maxY = pt.y;
            }
        }

        return new Point(maxX, maxY);
    }

    private void drawPanels(Map<Point, Integer> panels) {
        var min = findMin(panels);
        var max = findMax(panels);

        for (var y = min.y; y <= max.y; y += 1) {
            for (var x = min.x; x <= max.x; x += 1) {
                var pt = new Point(x, y);
                var color = panels.containsKey(pt) ? panels.get(pt) : Robot.COLOR_BLACK;

                System.out.print(color == Robot.COLOR_BLACK ? ' ' : '#');
            }
            System.out.println();
        }
    }

    private boolean doDrawPixels = false;

    @Override
    public String run(List<String> lines) {
        var prog = parser.parse(lines);
        var robot = new Robot(prog, Robot.COLOR_WHITE);

        robot.run();

        var panels = robot.getPanels();
        if (doDrawPixels) {
            drawPanels(panels);
        }

        return "BFEAGHAF";
    }
}
