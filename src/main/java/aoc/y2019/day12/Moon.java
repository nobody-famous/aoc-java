package aoc.y2019.day12;

import aoc.utils.geometry.Point3D;

public class Moon {
    public Point3D pos;
    public Point3D vel;

    public Moon(Point3D pos) {
        this.pos = pos;
        this.vel = new Point3D(0, 0, 0);
    }

    public String toString() {
        return "(<" + pos.x + "," + pos.y + "," + pos.z + ">" + ", <" + vel.x + "," + vel.y + "," + vel.z + ">)";
    }
}
