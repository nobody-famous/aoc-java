package aoc.y2018.day3;

import aoc.utils.geometry.Point;

public class Claim {
    public int id;
    public Point pt;
    public int w;
    public int h;

    public Claim(int id, Point pt, int w, int h) {
        this.id = id;
        this.pt = pt;
        this.w = w;
        this.h = h;
    }
}
