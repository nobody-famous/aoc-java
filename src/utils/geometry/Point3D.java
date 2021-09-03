package utils.geometry;

public class Point3D {
    public int x;
    public int y;
    public int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point3D)) {
            return false;
        }

        var pt3d = (Point3D) obj;

        return x == pt3d.x && y == pt3d.y && z == pt3d.z;
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    public int hashCode() {
        return (x * 10000) + (y * 100) + z;
    }
}
