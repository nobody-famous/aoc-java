package y2020.day24;

public class Tile {
    private int x;
    private int y;
    private int z;

    public Tile() {
        x = 0;
        y = 0;
        z = 0;
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
        var hash = x * x + y * y + z * z;
        return hash;
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
