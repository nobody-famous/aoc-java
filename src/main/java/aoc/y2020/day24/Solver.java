package aoc.y2020.day24;

import java.util.HashMap;
import java.util.Map;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Integer> {
    protected Map<Tile, Color> tiles = new HashMap<Tile, Color>();
    protected Direction[][] input;

    protected Solver(Direction[][] input, int expected) {
        super(expected);
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
