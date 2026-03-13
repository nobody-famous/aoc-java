package aoc.y2024.day6;

import aoc.utils.geometry.Point;

public class Grid extends aoc.utils.Grid {
    private Point start;

    public Grid(int rows, int cols) {
        super(rows, cols);
        start = new Point(-1, -1);
    }

    public boolean onMap(Point pt) {
        return onMap(pt.x, pt.y);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }
}
