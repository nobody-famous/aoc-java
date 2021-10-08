package y2019.day15;

import java.util.Map;

import utils.Problem;
import utils.geometry.Point;
import y2019.intcode.Parser;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    private Point findMin(Map<Point, Integer> grid) {
        var minX = Integer.MAX_VALUE;
        var minY = Integer.MAX_VALUE;

        for (var key : grid.keySet()) {
            if (key.x < minX) {
                minX = key.x;
            }

            if (key.y < minY) {
                minY = key.y;
            }
        }

        return new Point(minX, minY);
    }

    private Point findMax(Map<Point, Integer> grid) {
        var maxX = Integer.MIN_VALUE;
        var maxY = Integer.MIN_VALUE;

        for (var key : grid.keySet()) {
            if (key.x > maxX) {
                maxX = key.x;
            }

            if (key.y > maxY) {
                maxY = key.y;
            }
        }

        return new Point(maxX, maxY);
    }

    private char cellToChar(int cell) {
        return switch (cell) {
            case RepairDroid.Open -> ' ';
            case RepairDroid.Oxygen -> 'O';
            default -> '#';
        };
    }

    private void printGrid(Map<Point, Integer> grid) {
        var min = findMin(grid);
        var max = findMax(grid);

        for (var y = min.y; y <= max.y; y += 1) {
            for (var x = min.x; x <= max.x; x += 1) {
                var pt = new Point(x, y);
                var value = grid.containsKey(pt) ? grid.get(pt) : RepairDroid.Wall;
                var cell = (x == 0 && y == 0) ? 'X' : cellToChar(value);

                System.out.print(cell);
            }

            System.out.println();
        }
    }

    public Integer run() {
        var prog = parser.parse();
        var droid = new RepairDroid(prog);
        var mapper = new GridMapper(droid);
        var grid = mapper.mapGrid();

        printGrid(grid);

        return 0;
    }
}
