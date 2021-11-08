package aoc.y2019.day18;

import java.util.HashMap;
import java.util.Map;

import aoc.utils.Problem;
import aoc.utils.geometry.Point;

public abstract class Solver extends Problem<Integer> {
    private Parser parser;

    public Solver(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    protected abstract int doWork(Grid grid);

    private Point findKey(Grid grid, char key) {
        for (var entry : grid.getKeys().entrySet()) {
            if (entry.getValue().equals(key)) {
                return entry.getKey();
            }
        }

        return null;
    }

    private Map<Character, KeyDist> getDistances(Grid grid, Point start) {
        var mapper = new DistMapper(grid, start);

        return mapper.map();
    }

    protected Map<Point, Map<Character, KeyDist>> buildKeyMap(Grid grid) {
        var keyMap = new HashMap<Point, Map<Character, KeyDist>>();

        for (var entrance : grid.getEntrances()) {
            keyMap.put(entrance, getDistances(grid, entrance));
        }

        for (var key : grid.getKeys().values()) {
            var pt = findKey(grid, key);
            keyMap.put(pt, getDistances(grid, pt));
        }

        return keyMap;
    }

    public Integer run() {
        var grid = parser.parse();

        return doWork(grid);
    }
}
