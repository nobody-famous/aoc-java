package y2020.day24;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public abstract class Solver implements Problem {
    protected Map<Tile, Color> tiles = new HashMap<Tile, Color>();
    protected Direction[][] input;

    protected Solver(Direction[][] input) {
        this.input = input;
    }

    protected void processMoves(Direction[] dirs) {
        var tile = new Tile();

        for (var dir : dirs) {
            tile.move(dir);
        }

        if (tiles.containsKey(tile)) {
            tiles.remove(tile);
        } else {
            tiles.put(tile, Color.BLACK);
        }
    }
}
