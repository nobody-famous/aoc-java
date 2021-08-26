package utils.geometry;

public class Line {
    public Point start;
    public Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
