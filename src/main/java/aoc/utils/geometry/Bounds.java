package aoc.utils.geometry;

import java.util.List;

public class Bounds {
    public Point low;
    public Point high;

    public Bounds() {
        low = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        high = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void checkLow(Bounds bounds, Point pt) {
        if (pt.x < bounds.low.x) {
            bounds.low.x = pt.x;
        }

        if (pt.y < bounds.low.y) {
            bounds.low.y = pt.y;
        }
    }

    public static void checkHigh(Bounds bounds, Point pt) {
        if (pt.x > bounds.high.x) {
            bounds.high.x = pt.x;
        }

        if (pt.y > bounds.high.y) {
            bounds.high.y = pt.y;
        }
    }

    public static Bounds from(List<Point> points) {
        var bounds = new Bounds();

        for (var pt : points) {
            checkLow(bounds, pt);
            checkHigh(bounds, pt);
        }

        return bounds;
    }

    public String toString() {
        var sb = new StringBuilder();

        sb.append("[");
        sb.append(low);
        sb.append("..");
        sb.append(high);
        sb.append("]");
        return sb.toString();
    }
}
