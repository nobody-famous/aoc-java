package y2019.day15;

import utils.geometry.Point;

public class GridMapper {
    private RepairDroid droid;

    public GridMapper(RepairDroid droid) {
        this.droid = droid;
    }

    public Grid mapGrid() {
        var grid = new Grid();
        var pt = new Point(0, 0);

        grid.add(pt, RepairDroid.Open);

        visit(grid, pt);

        return grid;
    }

    private void visit(Grid grid, Point pt) {
        visit(grid, pt, null);
    }

    private void visit(Grid grid, Point pt, Integer dir) {
        try {
            tryMove(grid, pt, RepairDroid.North);
            tryMove(grid, pt, RepairDroid.South);
            tryMove(grid, pt, RepairDroid.East);
            tryMove(grid, pt, RepairDroid.West);
        } finally {
            if (dir != null) {
                droid.move(oppositeDir(dir));
            }
        }
    }

    private void tryMove(Grid grid, Point pt, int dir) {
        var newPt = newPoint(pt, dir);

        if (grid.seen(newPt)) {
            return;
        }

        var result = droid.move(dir);

        grid.add(newPt, result);

        if (result == RepairDroid.Open) {
            visit(grid, newPt, dir);
        }
    }

    private Point newPoint(Point pt, int dir) {
        return switch (dir) {
            case RepairDroid.North -> new Point(pt.x, pt.y - 1);
            case RepairDroid.South -> new Point(pt.x, pt.y + 1);
            case RepairDroid.East -> new Point(pt.x + 1, pt.y);
            case RepairDroid.West -> new Point(pt.x - 1, pt.y);
            default -> throw new RuntimeException("Invalid direction");
        };
    }

    private int oppositeDir(int dir) {
        return switch (dir) {
            case RepairDroid.North -> RepairDroid.South;
            case RepairDroid.South -> RepairDroid.North;
            case RepairDroid.East -> RepairDroid.West;
            case RepairDroid.West -> RepairDroid.East;
            default -> throw new RuntimeException("Invalid direction");
        };
    }
}
