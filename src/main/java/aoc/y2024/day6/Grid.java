package aoc.y2024.day6;

import aoc.utils.geometry.Point;

public record Grid(char[][] map, Point start) {
    public boolean onMap(Point pt) {
        return pt.x >= 0 && pt.x < map.length && pt.y >= 0 && pt.y < map[0].length;
    }

    public char get(Point pt) {
        return onMap(pt) ? map[pt.x][pt.y] : '\0';
    }

    public void set(Point pt, char ch) {
        if (onMap(pt)) {
            map[pt.x][pt.y] = ch;
        }
    }
}
