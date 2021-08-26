package utils.geometry;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manDist(Point pt) {
        return Math.abs(x - pt.x) + Math.abs(y - pt.y);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
