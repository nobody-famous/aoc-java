package aoc.y2019.day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import aoc.utils.geometry.Point;

public class Grid {
    private HashSet<Point> entrances;
    private HashSet<Point> path;
    private Map<Point, Character> keys;
    private Map<Character, Point> keyLocs;
    private Map<Point, Character> doors;
    private Map<Character, Integer> keyMasks;
    private Point middle;

    public Grid() {
        entrances = new HashSet<>();
        path = new HashSet<>();
        keys = new HashMap<>();
        keyLocs = new HashMap<>();
        doors = new HashMap<>();
        keyMasks = new HashMap<>();
    }

    public void setMiddle(Point pt) {
        middle = pt;
    }

    public Point getMiddle() {
        return middle;
    }

    public int getKeyMask(char key) {
        return keyMasks.containsKey(key) ? keyMasks.get(key) : 0;
    }

    public Map<Character, Integer> getKeyMasks() {
        return keyMasks;
    }

    public HashSet<Point> getPath() {
        return path;
    }

    public Map<Point, Character> getKeys() {
        return keys;
    }

    public Map<Character, Point> getKeyLocs() {
        return keyLocs;
    }

    public Map<Point, Character> getDoors() {
        return doors;
    }

    public HashSet<Point> getEntrances() {
        return entrances;
    }

    public void removeEntrance(Point pt) {
        entrances.remove(pt);
    }

    public void addEntrance(Point pt) {
        entrances.add(pt);
    }

    public void addToPath(Point pt) {
        path.add(pt);
    }

    public void addKey(Point pt, char key) {
        keyMasks.put(key, 1 << (key - 'a'));
        keys.put(pt, key);
        keyLocs.put(key, pt);
    }

    public void addDoor(Point pt, char key) {
        doors.put(pt, key);
    }
}
