package aoc.y2019.day18;

import aoc.utils.geometry.Point;

public class GraphNode {
    public Point pt;
    public Point enter;
    public int dist;
    public int needKeys;
    public int hasKeys;

    public GraphNode(Point pt, Point enter, int dist, int needKeys, int hasKeys) {
        this.pt = pt;
        this.enter = enter;
        this.dist = dist;
        this.needKeys = needKeys;
        this.hasKeys = hasKeys;
    }

    public String toString() {
        return "[" + pt + ", dist " + dist + ", need " + needKeys + ", has " + hasKeys + "]";
    }
}
