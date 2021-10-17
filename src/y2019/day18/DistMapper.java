package y2019.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import utils.geometry.Point;

public class DistMapper {
    private Grid grid;
    private Point start;
    private List<Walker> toVisit;
    private HashSet<Point> seen;
    private Map<Character, KeyDist> keyMap;

    private record Walker(Point pt, int dist, int keys, int doors) {
    }

    public DistMapper(Grid grid, Point start) {
        this.grid = grid;
        this.start = start;
        this.toVisit = new ArrayList<>();
        this.seen = new HashSet<>();
        this.keyMap = new HashMap<>();
    }

    public Map<Character, KeyDist> map() {
        toVisit.add(new Walker(start, 0, 0, 0));

        if (grid.getEntrances().size() > 1) {
            addEntrancesToVisit(start);
        }

        while (!toVisit.isEmpty()) {
            visitAll();
        }

        return keyMap;
    }

    private void addEntrancesToVisit(Point start) {
        var mask = grid.getKeys().containsKey(start) ? grid.getKeyMask(grid.getKeys().get(start)) : 0;

        for (var entrance : grid.getEntrances()) {
            if (!sameQuadrant(start, entrance)) {
                toVisit.add(new Walker(entrance, 0, mask, 0));
            }
        }
    }

    private boolean sameQuadrant(Point pt1, Point pt2) {
        var mid = grid.getMiddle();

        return (pt1.x < mid.x && pt1.y < mid.y && pt2.x < mid.x && pt2.y < mid.y)
                || (pt1.x < mid.x && pt1.y > mid.y && pt2.x < mid.x && pt2.y > mid.y)
                || (pt1.x > mid.x && pt1.y < mid.y && pt2.x > mid.x && pt2.y < mid.y)
                || (pt1.x > mid.x && pt1.y > mid.y && pt2.x > mid.x && pt2.y > mid.y);
    }

    private void visitAll() {
        var next = new ArrayList<Walker>();

        for (var walker : toVisit) {
            var toAdd = visit(walker);
            next.addAll(toAdd);
        }

        toVisit = next;
    }

    private int addItem(int set, char item) {
        return set | grid.getKeyMask(item);
    }

    private void addWalker(List<Walker> toAdd, Point pt, int dist, int keys, int doors) {
        if (seen.contains(pt) || !grid.getPath().contains(pt)) {
            return;
        }

        toAdd.add(new Walker(pt, dist, keys, doors));
    }

    private List<Walker> visit(Walker walker) {
        var toAdd = new ArrayList<Walker>();
        var pt = walker.pt;
        var newDist = walker.dist + 1;
        var keys = grid.getKeys().containsKey(pt) ? addItem(walker.keys, grid.getKeys().get(pt)) : walker.keys;
        var doors = grid.getDoors().containsKey(pt)
                ? addItem(walker.doors, Character.toLowerCase(grid.getDoors().get(pt)))
                : walker.doors;

        if (grid.getKeys().containsKey(pt)) {
            keyMap.put(grid.getKeys().get(pt),
                    new KeyDist(grid.getKeys().get(pt), walker.dist, walker.keys, walker.doors));
        }

        addWalker(toAdd, new Point(pt.x, pt.y - 1), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x, pt.y + 1), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x + 1, pt.y), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x - 1, pt.y), newDist, keys, doors);

        seen.add(walker.pt);

        return toAdd;
    }
}