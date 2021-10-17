package y2019.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utils.geometry.Point;

public class PathFinder {
    private Grid grid;
    private Map<Point, Map<Character, KeyDist>> keyMap;
    private int allKeysMask;
    private Map<Point, Map<Integer, Integer>> distances;

    public PathFinder(Grid grid, Map<Point, Map<Character, KeyDist>> keyMap) {
        this.grid = grid;
        this.keyMap = keyMap;

        allKeysMask = 0;
        for (var mask : grid.getKeyMasks().values()) {
            allKeysMask |= mask;
        }

        this.distances = new HashMap<>();

        for (var entrance : grid.getEntrances()) {
            this.distances.put(entrance, new HashMap<>());
        }

        for (var key : grid.getKeyMasks().keySet()) {
            var pt = grid.getKeyLocs().get(key);
            this.distances.put(pt, new HashMap<>());
        }
    }

    public int find() {
        var shortest = Integer.MAX_VALUE;

        for (var entrance : grid.getEntrances()) {
            var dist = traverse(entrance, 0, 0);

            if (dist < shortest) {
                shortest = dist;
            }
        }

        return shortest;
    }

    private Map<Character, KeyDist> findCandidates(Point pt, int foundKeys) {
        var distances = keyMap.get(pt);
        var candidates = new HashMap<Character, KeyDist>();

        for (var keyDist : distances.values()) {
            if (neededKeysFound(foundKeys, keyDist.doors())) {
                candidates.put(keyDist.key(), keyDist);
            }
        }

        removeDupes(candidates);

        return candidates;
    }

    private void removeDupes(Map<Character, KeyDist> map) {
        var toRemove = new ArrayList<Character>();
        var mapKeys = map.keySet();

        for (var keyDist : map.values()) {
            for (var key : mapKeys) {
                var mask = grid.getKeyMasks().get(key);

                if ((keyDist.keys() & mask) == mask) {
                    toRemove.add(key);
                }
            }
        }

        for (var key : toRemove) {
            map.remove(key);
        }
    }

    private boolean neededKeysFound(int areOpen, int needOpen) {
        return (areOpen & needOpen) == needOpen;
    }

    private int traverse(Point pt, int lastStep, int foundKeys) {
        if ((foundKeys & allKeysMask) == allKeysMask) {
            return lastStep;
        }

        var distKeysMap = distances.get(pt);
        if (distKeysMap.containsKey(foundKeys)) {
            return lastStep + distKeysMap.get(foundKeys);
        }

        var candidates = findCandidates(pt, foundKeys);
        var shortest = Integer.MAX_VALUE;

        for (var keyDist : candidates.values()) {
            var mask = grid.getKeyMasks().get(keyDist.key());

            if ((mask & foundKeys) != 0) {
                continue;
            }

            var newKeys = mask | keyDist.keys() | foundKeys;
            var newPt = grid.getKeyLocs().get(keyDist.key());
            var dist = traverse(newPt, keyDist.dist(), newKeys);

            if (dist < shortest) {
                shortest = dist;
            }
        }

        distKeysMap.put(foundKeys, shortest);

        return lastStep + shortest;
    }
}
