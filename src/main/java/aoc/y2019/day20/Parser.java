package aoc.y2019.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.geometry.Bounds;
import aoc.utils.geometry.Point;

public class Parser extends aoc.utils.Parser<Maze> {
    private char[][] matrix;
    private Maze maze = new Maze();

    private void readMatrix(List<String> lines) {
        matrix = new char[lines.size()][lines.get(0).length()];

        for (var y = 0; y < lines.size(); y += 1) {
            var line = lines.get(y);

            for (var x = 0; x < line.length(); x += 1) {
                matrix[y][x] = line.charAt(x);
            }
        }
    }

    private void addPoint(Point pt, char ch) {
        if (ch == '.') {
            maze.addPathPoint(pt);
        } else if (Character.isLetter(ch) || ch == ' ') {
            maze.addCenterPoint(pt);
        }
    }

    private void parseMaze(char[][] matrix) {
        for (var y = 2; y < matrix.length - 2; y += 1) {
            for (var x = 2; x < matrix[y].length - 2; x += 1) {
                addPoint(new Point(x, y), matrix[y][x]);
            }
        }
    }

    private Map<Point, String> findTopJumps(Point start, Point end) {
        var jumps = new HashMap<Point, String>();
        var delta = new Point(1, 0);

        while (!start.equals(end)) {
            if (maze.path.contains(start)) {
                var name = "" + matrix[start.y - 2][start.x] + matrix[start.y - 1][start.x];
                jumps.put(new Point(start), name);
            }
            start.inc(delta);
        }

        return jumps;
    }

    private Map<Point, String> findBottomJumps(Point start, Point end) {
        var jumps = new HashMap<Point, String>();
        var delta = new Point(1, 0);

        while (!start.equals(end)) {
            if (maze.path.contains(start)) {
                var name = "" + matrix[start.y + 1][start.x] + matrix[start.y + 2][start.x];
                jumps.put(new Point(start), name);
            }
            start.inc(delta);
        }

        return jumps;
    }

    private Map<Point, String> findLeftJumps(Point start, Point end) {
        var jumps = new HashMap<Point, String>();
        var delta = new Point(0, 1);

        while (!start.equals(end)) {
            if (maze.path.contains(start)) {
                var name = "" + matrix[start.y][start.x - 2] + matrix[start.y][start.x - 1];
                jumps.put(new Point(start), name);
            }
            start.inc(delta);
        }

        return jumps;
    }

    private Map<Point, String> findRightJumps(Point start, Point end) {
        var jumps = new HashMap<Point, String>();
        var delta = new Point(0, 1);

        while (!start.equals(end)) {
            if (maze.path.contains(start)) {
                var name = "" + matrix[start.y][start.x + 1] + matrix[start.y][start.x + 2];
                jumps.put(new Point(start), name);
            }
            start.inc(delta);
        }

        return jumps;
    }

    private void findOuterJumps() {
        var endRow = matrix.length - 3;
        var endCol = matrix[0].length - 3;

        maze.outerJumps.putAll(findTopJumps(new Point(2, 2), new Point(endCol, 2)));
        maze.outerJumps.putAll(findBottomJumps(new Point(2, endRow), new Point(endCol, endRow)));
        maze.outerJumps.putAll(findLeftJumps(new Point(2, 2), new Point(2, endRow)));
        maze.outerJumps.putAll(findRightJumps(new Point(endCol, 2), new Point(endCol, endRow)));

        for (var entry : maze.outerJumps.entrySet()) {
            maze.outerJumpsByName.put(entry.getValue(), entry.getKey());
        }
    }

    private void findInnerJumps() {
        var bounds = Bounds.from(new ArrayList<>(maze.center));
        var startRow = bounds.low.y - 1;
        var startCol = bounds.low.x - 1;
        var endRow = bounds.high.y + 1;
        var endCol = bounds.high.x + 1;

        maze.innerJumps.putAll(findTopJumps(new Point(startCol, endRow), new Point(endCol, endRow)));
        maze.innerJumps.putAll(findBottomJumps(new Point(startCol, startRow), new Point(endCol, startRow)));
        maze.innerJumps.putAll(findLeftJumps(new Point(endCol, startRow), new Point(endCol, endRow)));
        maze.innerJumps.putAll(findRightJumps(new Point(startCol, startRow), new Point(startCol, endRow)));

        for (var entry : maze.innerJumps.entrySet()) {
            maze.innerJumpsByName.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public Maze parse(List<String> lines) {
        try {
            readMatrix(lines);
            parseMaze(matrix);
            findOuterJumps();
            findInnerJumps();

            return maze;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
