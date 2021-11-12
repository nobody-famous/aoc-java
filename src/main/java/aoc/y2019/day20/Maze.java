package aoc.y2019.day20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import aoc.utils.geometry.Point;

public class Maze {
    public HashSet<Point> path = new HashSet<>();
    public HashSet<Point> center = new HashSet<>();
    public Map<Point, String> outerJumps = new HashMap<>();
    public Map<String, Point> outerJumpsByName = new HashMap<>();
    public Map<Point, String> innerJumps = new HashMap<>();
    public Map<String, Point> innerJumpsByName = new HashMap<>();

    public void addPathPoint(Point pt) {
        path.add(pt);
    }

    public void addCenterPoint(Point pt) {
        center.add(pt);
    }
}
