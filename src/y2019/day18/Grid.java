package y2019.day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import utils.geometry.Point;

public class Grid {
    private Point entrance;
    private HashSet<Point> path;
    private Map<Point, Character> keys;
    private Map<Point, Character> doors;

    public Grid() {
        path = new HashSet<>();
        keys = new HashMap<>();
        doors = new HashMap<>();
    }

    public HashSet<Point> getPath() {
        return path;
    }

    public Map<Point, Character> getKeys() {
        return keys;
    }

    public Map<Point, Character> getDoors() {
        return doors;
    }

    public Point getEntrance() {
        return entrance;
    }

    public void setEntrance(Point pt) {
        entrance = pt;
    }

    public void addToPath(Point pt) {
        path.add(pt);
    }

    public void addKey(Point pt, char key) {
        keys.put(pt, key);
    }

    public void addDoor(Point pt, char key) {
        doors.put(pt, key);
    }
}
