package y2019.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PathFinder {
    private Map<Character, Map<Character, KeyDist>> keyMap;

    public PathFinder(Map<Character, Map<Character, KeyDist>> keyMap) {
        this.keyMap = keyMap;
    }

    public void find() {
        traverse('@', 0, new HashSet<Character>());
    }

    private Map<Character, KeyDist> findCandidates(char key, HashSet<Character> openDoors) {
        var distances = keyMap.get(key);
        var candidates = new HashMap<Character, KeyDist>();

        for (var keyDist : distances.values()) {
            if (doorsOpen(openDoors, keyDist.doors())) {
                candidates.put(keyDist.key(), keyDist);
            }
        }

        removeDupes(candidates);

        return candidates;
    }

    private void removeDupes(Map<Character, KeyDist> map) {
        var toRemove = new ArrayList<Character>();

        for (var keyDist : map.values()) {
            for (var key : keyDist.keys()) {
                if (map.containsKey(key)) {
                    toRemove.add(key);
                }
            }
        }

        for (var key : toRemove) {
            map.remove(key);
        }
    }

    private boolean doorsOpen(HashSet<Character> areOpen, HashSet<Character> needOpen) {
        for (var door : needOpen) {
            if (!areOpen.contains(door)) {
                return false;
            }
        }

        return true;
    }

    private int traverse(char key, int curDist, HashSet<Character> openDoors) {
        var candidates = findCandidates(key, openDoors);

        System.out.println(candidates);

        return 0;
    }
}
