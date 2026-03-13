package aoc.utils;

import java.util.List;

import aoc.utils.geometry.Point;

public class Grid {
    private char[][] map;

    public Grid(int rows, int cols) {
        map = new char[rows][cols];
    }

    public int getRows() {
        return map.length;
    }

    public int getCols() {
        return map[0].length;
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

    public static Grid parse(List<String> lines) {
        var grid = new Grid(lines.size(), lines.get(0).length());

        for (var row = 0; row < lines.size(); row += 1) {
            var line = lines.get(row);

            for (var col = 0; col < line.length(); col += 1) {
                grid.set(row, col, line.charAt(col));
            }
        }

        return grid;
    }
}
