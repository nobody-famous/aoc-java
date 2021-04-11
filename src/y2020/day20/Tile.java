package y2020.day20;

public class Tile {
    private int id;
    private String[] data;
    private String north;
    private String south;
    private String east;
    private String west;

    public Tile(int id, String[] data) {
        this.id = id;
        this.data = data;

        north = data[0];
        south = data[data.length - 1];

        char[] chars = new char[data.length];
        for (var row = 0; row < data.length; row += 1) {
            chars[row] = data[row].charAt(data.length - 1);
        }

        east = new String(chars);

        chars = new char[data.length];
        for (int row = 0; row < data.length; row += 1) {
            chars[row] = data[row].charAt(0);
        }

        west = new String(chars);
    }

    public int getId() {
        return id;
    }

    public String[] getData() {
        return data;
    }

    public String getNorth() {
        return north;
    }

    public String getSouth() {
        return south;
    }

    public String getEast() {
        return east;
    }

    public String getWest() {
        return west;
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
        builder.append("north " + north + "\n");
        builder.append("south " + south + "\n");
        builder.append("east " + east + "\n");
        builder.append("west " + west + "\n");

        for (var line : data) {
            builder.append(line + "\n");
        }

        return builder.toString();
    }
}
