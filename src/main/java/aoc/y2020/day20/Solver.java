package aoc.y2020.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Tile[] input;

    protected Solver(Tile[] input, long expected) {
        super(expected);
        this.input = input;
    }

    protected List<Tile> permutations(Tile tile) {
        var perms = new ArrayList<Tile>();
        var curr = tile;

        for (var loop = 0; loop < 4; loop += 1) {
            perms.add(curr);
            perms.add(curr.flip());

            curr = curr.rotate();
        }

        return perms;
    }

    private void addBorderToMap(Map<String, Integer> borders, String border) {
        var value = 0;

        if (borders.containsKey(border)) {
            value = borders.get(border);
        }

        borders.put(border, value + 1);
    }

    protected Map<String, Integer> bordersMap(Map<Integer, List<Tile>> tiles) {
        var borders = new HashMap<String, Integer>();

        for (var tileList : tiles.values()) {
            for (var tile : tileList) {
                addBorderToMap(borders, tile.getBorder(Tile.NORTH));
                addBorderToMap(borders, tile.getBorder(Tile.SOUTH));
                addBorderToMap(borders, tile.getBorder(Tile.EAST));
                addBorderToMap(borders, tile.getBorder(Tile.WEST));
            }
        }

        return borders;
    }

    protected Map<Integer, List<Tile>> tilePerms(Tile[] data) {
        var tiles = new HashMap<Integer, List<Tile>>();

        for (var tile : data) {
            tiles.put(tile.getId(), permutations(tile));
        }

        return tiles;
    }

    protected int countMatches(Map<String, Integer> borders, Tile tile) {
        var count = 0;

        if (borders.get(tile.getBorder(Tile.NORTH)) > 4) {
            count += 1;
        }

        if (borders.get(tile.getBorder(Tile.SOUTH)) > 4) {
            count += 1;
        }

        if (borders.get(tile.getBorder(Tile.EAST)) > 4) {
            count += 1;
        }

        if (borders.get(tile.getBorder(Tile.WEST)) > 4) {
            count += 1;
        }

        return count;
    }
}
