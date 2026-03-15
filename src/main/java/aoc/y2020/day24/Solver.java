package aoc.y2020.day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    protected Map<Tile, Color> tiles = new HashMap<>();

    protected void processMoves(List<Direction> dirs) {
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
