package aoc.y2019.day12;

import aoc.utils.geometry.Point3D;

public class MoonLoops {
    private Loop xLoop;
    private Loop yLoop;
    private Loop zLoop;
    private Point3D counts;

    public MoonLoops() {
        xLoop = new Loop();
        yLoop = new Loop();
        zLoop = new Loop();

        counts = null;
    }

    public Point3D getCounts() {
        return counts;
    }

    public void insert(Point3D pos) {
        if (hasAll()) {
            return;
        }

        xLoop.insert(pos.x);
        yLoop.insert(pos.y);
        zLoop.insert(pos.z);

        if (xLoop.hasLoop() && yLoop.hasLoop() && zLoop.hasLoop()) {
            counts = new Point3D(xLoop.loopSize(), yLoop.loopSize(), zLoop.loopSize());
        }
    }

    public boolean hasAll() {
        return counts != null;
    }
}
