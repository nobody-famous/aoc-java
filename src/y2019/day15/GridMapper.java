package y2019.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.geometry.Point;

public class GridMapper {
    private long[] prog;
    private List<DroidClone> clones;
    private Grid grid;

    private class DroidClone {
        public RepairDroid droid;
        public Point loc;

        public DroidClone(RepairDroid droid, Point loc) {
            this.droid = new RepairDroid(droid);
            this.loc = loc;
        }
    }

    public GridMapper(long[] prog) {
        this.prog = prog;
    }

    public Grid mapGrid() {
        var start = new Point(0, 0);
        var droid = new RepairDroid(prog);
        var clone = new DroidClone(droid, start);

        clones = Arrays.<DroidClone>asList(clone);
        grid = new Grid();

        while (!clones.isEmpty()) {
            nextRound();
        }

        return grid;
    }

    private void nextRound() {
        var next = new ArrayList<DroidClone>();

        for (var clone : clones) {
            move(next, clone, RepairDroid.North);
            move(next, clone, RepairDroid.South);
            move(next, clone, RepairDroid.East);
            move(next, clone, RepairDroid.West);
        }

        clones = next;
    }

    private void move(List<DroidClone> next, DroidClone clone, int dir) {
        var droid = new RepairDroid(clone.droid);
        var result = droid.move(dir);
        var droidPt = newPoint(clone.loc, dir);

        if (grid.seen(droidPt)) {
            return;
        }

        grid.add(droidPt, result);

        if (result != RepairDroid.Wall) {
            next.add(new DroidClone(droid, droidPt));
        }
    }

    private Point newPoint(Point pt, int dir) {
        return switch (dir) {
            case RepairDroid.North -> new Point(pt.x, pt.y + 1);
            case RepairDroid.South -> new Point(pt.x, pt.y - 1);
            case RepairDroid.East -> new Point(pt.x + 1, pt.y);
            case RepairDroid.West -> new Point(pt.x - 1, pt.y);
            default -> throw new RuntimeException("Invalid direction");
        };
    }
}
