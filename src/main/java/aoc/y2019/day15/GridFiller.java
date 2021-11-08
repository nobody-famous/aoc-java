package aoc.y2019.day15;

import java.util.HashSet;

import aoc.utils.geometry.Point;

public class GridFiller {
    private Grid grid;
    private HashSet<Point> seen;
    private HashSet<Point> toVisit;

    public GridFiller(Grid grid) {
        this.grid = grid;
        this.seen = new HashSet<>();
        this.toVisit = new HashSet<>();
    }

    public int fill(Point startPt) {
        var rounds = 0;

        toVisit.add(startPt);
        nextRound();

        while (!toVisit.isEmpty()) {
            nextRound();

            rounds += 1;
        }

        return rounds;
    }

    private void nextRound() {
        var next = new HashSet<Point>();

        for (var pt : toVisit) {
            seen.add(pt);
            addCandidates(next, pt);
        }

        toVisit = next;
    }

    private void addCandidates(HashSet<Point> next, Point pt) {
        addCandidate(next, new Point(pt.x, pt.y + 1));
        addCandidate(next, new Point(pt.x, pt.y - 1));
        addCandidate(next, new Point(pt.x + 1, pt.y));
        addCandidate(next, new Point(pt.x - 1, pt.y));
    }

    private void addCandidate(HashSet<Point> next, Point pt) {
        if (seen.contains(pt) || grid.get(pt) == RepairDroid.Wall) {
            return;
        }

        next.add(pt);
    }
}
