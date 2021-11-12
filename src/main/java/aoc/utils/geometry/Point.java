package aoc.utils.geometry;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point copy) {
        this(copy.x, copy.y);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }

        var pt = (Point) obj;
        return x == pt.x && y == pt.y;
    }

    public void inc(Point delta) {
        x += delta.x;
        y += delta.y;
    }

    public int manDist(Point pt) {
        return Math.abs(x - pt.x) + Math.abs(y - pt.y);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public int hashCode() {
        return (x * 100) + y;
    }
}
