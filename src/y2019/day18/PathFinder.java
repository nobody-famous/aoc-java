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
        for (var key : keyMasks.keySet()) {
            this.distances.put(key, new HashMap<>());
        }
    }

    public void find() {
        var dist = traverse('@', 0, 0);
        System.out.println("Final dist " + dist);
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
                if (!keyMasks.containsKey(key)) {
                    continue;
                }

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

    private String foundKeysString(int foundKeys) {
        var str = new StringBuilder();

        for (var entry : keyMasks.entrySet()) {
            if ((entry.getValue() & foundKeys) != 0) {
                str.append(entry.getKey());
            }
        }

        return str.toString();
    }

    private int traverse(char key, int curDist, int foundKeys) {
        if ((foundKeys & allKeysMask) == allKeysMask) {
            return curDist;
        }

        var candidates = findCandidates(key, foundKeys);
        var shortest = Integer.MAX_VALUE;

        for (var keyDist : candidates.values()) {
            var mask = keyMasks.get(keyDist.key());

            if ((mask & foundKeys) != 0) {
                continue;
            }

            var newKeys = mask | keyDist.keys() | foundKeys;
            var dist = traverse(keyDist.key(), keyDist.dist() + curDist, newKeys);

            if (dist < shortest) {
                shortest = dist;
            }
        }

        return shortest;
    }
}
