package y2019.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathFinder {
    private Map<Character, Map<Character, KeyDist>> keyMap;
    private Map<Character, Integer> keyMasks;
    private int allKeysMask;
    private Map<Character, Map<Integer, Integer>> distances;

    public PathFinder(Map<Character, Map<Character, KeyDist>> keyMap, Map<Character, Integer> keyMasks) {
        this.keyMap = keyMap;
        this.keyMasks = keyMasks;

        allKeysMask = 0;
        for (var mask : keyMasks.values()) {
            allKeysMask |= mask;
        }

        this.distances = new HashMap<>();
        this.distances.put('@', new HashMap<>());
        for (var key : keyMasks.keySet()) {
            this.distances.put(key, new HashMap<>());
        }
    }

    public int find() {
        return traverse('@', 0, 0);
    }

    private Map<Character, KeyDist> findCandidates(char key, int foundKeys) {
        var distances = keyMap.get(key);
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
                var mask = keyMasks.get(key);

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

    private int traverse(char key, int lastStep, int foundKeys) {
        if ((foundKeys & allKeysMask) == allKeysMask) {
            return lastStep;
        }

        var distKeysMap = distances.get(key);
        if (distKeysMap.containsKey(foundKeys)) {
            return lastStep + distKeysMap.get(foundKeys);
        }

        var candidates = findCandidates(key, foundKeys);
        var shortest = Integer.MAX_VALUE;

        for (var keyDist : candidates.values()) {
            var mask = keyMasks.get(keyDist.key());

            if ((mask & foundKeys) != 0) {
                continue;
            }

            var newKeys = mask | keyDist.keys() | foundKeys;
            var dist = traverse(keyDist.key(), keyDist.dist(), newKeys);

            if (dist < shortest) {
                shortest = dist;
            }
        }

        distKeysMap.put(foundKeys, shortest);

        return lastStep + shortest;
    }
}
