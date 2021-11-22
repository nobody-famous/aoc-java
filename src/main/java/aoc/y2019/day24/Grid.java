package aoc.y2019.day24;

public class Grid {
    public static int EMPTY = 0;
    public static int BUG = 1;

    public static int GRID_SIZE = 5;

    private int cells = 0;

    public void set(int x, int y, int value) {
        if (!isValidValue(value)) {
            throw new RuntimeException("Invalid value " + value);
        }

        if (!isOnGrid(x, y)) {
            throw new RuntimeException("Invalid coords " + x + "," + y);
        }

        var cell = toCell(x, y);
        var mask = 1 << cell;

        if (value == BUG) {
            cells |= mask;
        }
    }

    public int getRating() {
        return cells;
    }

    public int get(int x, int y) {
        if (!isOnGrid(x, y)) {
            return EMPTY;
        }

        var cell = toCell(x, y);
        var mask = 1 << cell;

        return (cells & mask) != 0 ? BUG : EMPTY;
    }

    private int toCell(int x, int y) {
        return (y * GRID_SIZE) + x;
    }

    private boolean isValidValue(int value) {
        return value == EMPTY || value == BUG;
    }

    private boolean isOnGrid(int x, int y) {
        return isInRange(x) && isInRange(y);
    }

    private boolean isInRange(int value) {
        return value >= 0 && value < 5;
    }

    public String toString() {
        var sb = new StringBuilder();
        var mask = 1;

        for (var y = 0; y < GRID_SIZE; y += 1) {
            for (var x = 0; x < GRID_SIZE; x += 1) {
                if ((cells & mask) != 0) {
                    sb.append("#");
                } else {
                    sb.append(".");
                }

                mask <<= 1;
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
