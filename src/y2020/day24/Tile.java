package y2020.day24;

public class Tile {
    private int x;
    private int y;
    private int z;

    public Tile() {
        this(0, 0, 0);
    }

    public Tile(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(Direction dir) {
        switch (dir) {
        case EAST -> {
            x += 1;
            y -= 1;
        }
        case WEST -> {
            x -= 1;
            y += 1;
        }
        case NORTHEAST -> {
            x += 1;
            z -= 1;
        }
        case NORTHWEST -> {
            y += 1;
            z -= 1;
        }
        case SOUTHEAST -> {
            y -= 1;
            z += 1;
        }
        case SOUTHWEST -> {
            x -= 1;
            z += 1;
        }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean equals(Object obj) {
        var them = (Tile) obj;
        return x == them.x && y == them.y && z == them.z;
    }

    public int hashCode() {
        var hash = x * 1000 + y * 100 + z * 10;
        return hash;
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
