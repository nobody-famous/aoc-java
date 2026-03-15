package aoc.y2020.day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    protected Map<Tile, Color> newTiles;

    private Tile[] getNeighbors(Tile tile) {
        return new Tile[]{ new Tile(tile.getX(), tile.getY() + 1, tile.getZ() - 1),
                new Tile(tile.getX() + 1, tile.getY(), tile.getZ() - 1),
                new Tile(tile.getX() + 1, tile.getY() - 1, tile.getZ()),
                new Tile(tile.getX(), tile.getY() - 1, tile.getZ() + 1),
                new Tile(tile.getX() - 1, tile.getY(), tile.getZ() + 1),
                new Tile(tile.getX() - 1, tile.getY() + 1, tile.getZ()) };
    }

    private int countBlacks(Tile[] neighbors) {
        var count = 0;

        for (var tile : neighbors) {
            if (tiles.containsKey(tile)) {
                count += 1;
            }
        }

        return count;
    }

    private void checkWhites(Tile[] neighbors) {
        for (var neighbor : neighbors) {
            if (tiles.containsKey(neighbor)) {
                continue;
            }

            var newNeighbors = getNeighbors(neighbor);
            var count = countBlacks(newNeighbors);

            if (count == 2) {
                newTiles.put(neighbor, Color.BLACK);
            }
        }
    }

    private void processNeighbors(Tile tile) {
        var count = 0;
        var neighbors = getNeighbors(tile);

        count = countBlacks(neighbors);
        if (count != 0 && count <= 2) {
            newTiles.put(tile, Color.BLACK);
        }

        checkWhites(neighbors);
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);

        for (var dirs : input) {
            processMoves(dirs);
        }

        for (var day = 0; day < 100; day += 1) {
            newTiles = new HashMap<>();
            for (var tile : tiles.keySet()) {
                processNeighbors(tile);
            }

            tiles = newTiles;
        }

        return newTiles.size();
    }
}
