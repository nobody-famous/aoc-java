package aoc.y2020.day20;

public class Tile {
    private int id;
    private String[] data;
    private String[] borders = new String[4];

    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;

    public Tile(int id, String[] data) {
        this.id = id;
        this.data = data;

        borders[NORTH] = data[0];
        borders[SOUTH] = data[data.length - 1];

        char[] chars = new char[data.length];
        for (var row = 0; row < data.length; row += 1) {
            chars[row] = data[row].charAt(data.length - 1);
        }

        borders[EAST] = new String(chars);

        chars = new char[data.length];
        for (int row = 0; row < data.length; row += 1) {
            chars[row] = data[row].charAt(0);
        }

        borders[WEST] = new String(chars);
    }

    public int getId() {
        return id;
    }

    public String[] getData() {
        return data;
    }

    public String getBorder(int border) {
        if (border < 0 || border > 3) {
            throw new RuntimeException("Invalid border requested " + border);
        }

        return borders[border];
    }

    private Tile charsToTile(char[][] out) {
        var strs = new String[data.length];
        for (var y = 0; y < data.length; y += 1) {
            strs[y] = new String(out[y]);
        }

        return new Tile(id, strs);
    }

    public Tile rotate() {
        var out = new char[data.length][data.length];

        for (int row = 0; row < data.length; row += 1) {
            for (int col = 0, outCol = data.length - 1; col < data.length; col += 1, outCol -= 1) {
                out[row][outCol] = data[col].charAt(row);
            }
        }

        return charsToTile(out);
    }

    public Tile flip() {
        var out = new char[data.length][data.length];

        for (int row = 0; row < data.length; row += 1) {
            for (int col = 0, outCol = data.length - 1; col < data.length; col += 1, outCol -= 1) {
                out[row][outCol] = data[row].charAt(col);
            }
        }

        return charsToTile(out);
    }

    public String toString() {
        var builder = new StringBuilder();

        builder.append("Tile " + id + "\n");

        for (var line : data) {
            builder.append(line + "\n");
        }

        return builder.toString();
    }
}
