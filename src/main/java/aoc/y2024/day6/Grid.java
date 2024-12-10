package aoc.y2024.day6;

import aoc.utils.geometry.Point;

public class Grid {
    private char[][] map;
    private Point start;

    public Grid(int rows, int cols) {
        map = new char[rows][cols];
        start = new Point(-1, -1);
    }

    public boolean onMap(Point pt) {
        return onMap(pt.x, pt.y);
    }

    public boolean onMap(int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }

    public char get(Point pt) {
        return get(pt.x, pt.y);
    }

    public char get(int row, int col) {
        return onMap(row, col) ? map[row][col] : '\0';
    }

    public void set(Point pt, char ch) {
        set(pt.x, pt.y, ch);
    }

    public void set(int row, int col, char ch) {
        if (onMap(row, col)) {
            map[row][col] = ch;
        }
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }
}
