package y2020.day24;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public class Part1 implements Problem {
    private Map<Tile, Color> tiles = new HashMap<Tile, Color>();
    private Direction[][] input;

    public Part1(Direction[][] input) {
        this.input = input;
    }

    private void processMoves(Direction[] dirs) {
        var tile = new Tile();

        for (var dir : dirs) {
            tile.move(dir);
        }

        if (!tiles.containsKey(tile)) {
            tiles.put(tile, Color.BLACK);
        } else {
            var color = tiles.get(tile);
            tiles.put(tile, color == Color.WHITE ? Color.BLACK : Color.WHITE);
        }
    }

    public long solve() {
        for (var dirs : input) {
            processMoves(dirs);
        }

        var sum = 0L;
        for (var color : tiles.values()) {
            if (color == Color.BLACK) {
                sum += 1;
            }
        }

        System.out.println(sum);

        return sum;
    }
}
