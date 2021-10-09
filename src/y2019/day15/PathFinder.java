package y2019.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import utils.geometry.Point;

public class PathFinder {
    private Grid grid;
    private HashSet<Point> seen;
    private List<Point> toVisit;

    public PathFinder(Grid grid) {
        this.grid = grid;
        this.seen = new HashSet<>();
    }

    public int findMinDist() {
        var dist = 0;

        toVisit = Arrays.<Point>asList(new Point(0, 0));

        while (!toVisit.isEmpty() && !hasTarget(toVisit)) {
            nextRound();
            dist += 1;
        }

        return dist;
    }

    private void nextRound() {
        var next = new ArrayList<Point>();

        for (var pt : toVisit) {
            if (seen.contains(pt)) {
                continue;
            }

            seen.add(pt);

            addCandidates(next, pt);
        }

        toVisit = next;
    }

    private void addCandidates(List<Point> next, Point pt) {
        addPoint(next, new Point(pt.x, pt.y + 1));
        addPoint(next, new Point(pt.x, pt.y - 1));
        addPoint(next, new Point(pt.x + 1, pt.y));
        addPoint(next, new Point(pt.x - 1, pt.y));
    }

    private void addPoint(List<Point> next, Point pt) {
        if (!seen.contains(pt) && grid.get(pt) != RepairDroid.Wall) {
            next.add(pt);
        }
    }

    private boolean hasTarget(List<Point> toVisit) {
        for (var pt : toVisit) {
            if (pt.equals(grid.getOxygen())) {
                return true;
            }
        }

        return false;
    }
}
