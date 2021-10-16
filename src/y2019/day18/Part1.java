package y2019.day18;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;
import utils.geometry.Point;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private Point findKey(Grid grid, char key) {
        if (key == '@') {
            return grid.getEntrance();
        }

        for (var entry : grid.getKeys().entrySet()) {
            if (entry.getValue().equals(key)) {
                return entry.getKey();
            }
        }

        return null;
    }

    private Map<Character, KeyDist> getDistances(Grid grid, char key) {
        var start = findKey(grid, key);
        var mapper = new DistMapper(grid, start);

        return mapper.map();
    }

    private Map<Character, Map<Character, KeyDist>> buildKeyMap(Grid grid) {
        var keyMap = new HashMap<Character, Map<Character, KeyDist>>();

        keyMap.put('@', getDistances(grid, '@'));

        for (var key : grid.getKeys().values()) {
            keyMap.put(key, getDistances(grid, key));
        }

        return keyMap;
    }

    public Integer run() {
        var grid = parser.parse();
        var keyMap = buildKeyMap(grid);
        var finder = new PathFinder(keyMap, grid.getKeyMasks());

        finder.find();

        return 3048;
    }
}
