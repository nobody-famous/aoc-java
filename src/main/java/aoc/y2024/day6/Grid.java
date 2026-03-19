package aoc.y2024.day6;

import aoc.utils.geometry.Point;

public class Grid extends aoc.utils.Grid {
    private Grid.Loc start;

    public Grid(int rows, int cols) {
        super(rows, cols);
        start = new Grid.Loc(-1, -1);
    }

    public boolean onMap(Point pt) {
        return onMap(pt.x, pt.y);
    }

    public Grid.Loc getStart() {
        return start;
    }

    public void setStart(Grid.Loc start) {
        this.start = start;
    }
}
