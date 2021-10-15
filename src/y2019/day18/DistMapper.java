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

    private record Walker(Point pt, int dist, HashSet<Character> keys, HashSet<Character> doors) {
    }

    public DistMapper(Grid grid, Point start) {
        this.grid = grid;
        this.start = start;
        this.toVisit = new ArrayList<>();
        this.seen = new HashSet<>();
        this.keyMap = new HashMap<>();
    }

    public Map<Character, KeyDist> map() {
        toVisit.add(new Walker(start, 0, new HashSet<Character>(), new HashSet<Character>()));

        while (!toVisit.isEmpty()) {
            visitAll();
        }

        return keyMap;
    }

    private void visitAll() {
        var next = new ArrayList<Walker>();

        for (var walker : toVisit) {
            var toAdd = visit(walker);
            next.addAll(toAdd);
        }

        toVisit = next;
    }

    private HashSet<Character> addItem(HashSet<Character> set, char item) {
        var newSet = new HashSet<Character>(set);

        newSet.add(item);

        return newSet;
    }

    private void addWalker(List<Walker> toAdd, Point pt, int dist, HashSet<Character> keys, HashSet<Character> doors) {
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
        var doors = grid.getDoors().containsKey(pt) ? addItem(walker.doors, grid.getDoors().get(pt)) : walker.doors;

        if (grid.getKeys().containsKey(pt)) {
            keyMap.put(grid.getKeys().get(pt), new KeyDist(grid.getKeys().get(pt), walker.dist,
                    new HashSet<Character>(walker.keys), new HashSet<Character>(walker.doors)));
        }

        addWalker(toAdd, new Point(pt.x, pt.y - 1), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x, pt.y + 1), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x + 1, pt.y), newDist, keys, doors);
        addWalker(toAdd, new Point(pt.x - 1, pt.y), newDist, keys, doors);

        seen.add(walker.pt);

        return toAdd;
    }
}
