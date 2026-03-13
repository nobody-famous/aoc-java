package aoc.y2024.day4;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.geometry.Point;

public class Grid {
    private char[][] map;

    public Grid(int rows, int cols) {
        map = new char[rows][cols];
    }

    public void set(int row, int col, char ch) {
        map[row][col] = ch;
    }

    public char get(int row, int col) {
        return map[row][col];
    }

    public boolean onMap(int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }

    public List<Point> findAll(char ch) {
        var points = new ArrayList<Point>();

        for (var row = 0; row < map.length; row += 1) {
            for (var col = 0; col < map[0].length; col += 1) {
                if (map[row][col] == ch) {
                    points.add(new Point(row, col));
                }
            }
        }

        return points;
    }
}
