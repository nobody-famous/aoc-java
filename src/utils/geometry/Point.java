package utils.geometry;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }

        var pt = (Point) obj;
        return x == pt.x && y == pt.y;
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
