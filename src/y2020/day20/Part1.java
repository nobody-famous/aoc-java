package y2020.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Problem;

public class Part1 implements Problem {
    private Tile[] input;

    public Part1(Tile[] input) {
        this.input = input;
    }

    private List<Tile> permutations(Tile tile) {
        var perms = new ArrayList<Tile>();
        var curr = tile;

        for (var loop = 0; loop < 4; loop += 1) {
            perms.add(curr);
            perms.add(curr.flip());

            curr = curr.rotate();
        }

        return perms;
    }

    private void addBorder(Map<String, Integer> borders, String border) {
        var value = 0;

        if (borders.containsKey(border)) {
            value = borders.get(border);
        }

        borders.put(border, value + 1);
    }

    private Map<String, Integer> bordersMap(Map<Integer, List<Tile>> tiles) {
        var borders = new HashMap<String, Integer>();

        for (var tileList : tiles.values()) {
            for (var tile : tileList) {
                addBorder(borders, tile.getNorth());
                addBorder(borders, tile.getSouth());
                addBorder(borders, tile.getEast());
                addBorder(borders, tile.getWest());
            }
        }

        return borders;
    }

    private Map<Integer, List<Tile>> tilePerms(Tile[] data) {
        var tiles = new HashMap<Integer, List<Tile>>();

        for (var tile : data) {
            tiles.put(tile.getId(), permutations(tile));
        }

        return tiles;
    }

    private int countMatches(Map<String, Integer> borders, Tile tile) {
        var count = 0;

        if (borders.get(tile.getNorth()) > 4) {
            count += 1;
        }

        if (borders.get(tile.getSouth()) > 4) {
            count += 1;
        }

        if (borders.get(tile.getEast()) > 4) {
            count += 1;
        }

        if (borders.get(tile.getWest()) > 4) {
            count += 1;
        }

        return count;
    }

    public long solve() {
        var tiles = tilePerms(input);
        var borders = bordersMap(tiles);
        var answer = 0L;

        for (var tile : input) {
            var count = countMatches(borders, tile);

            if (count == 2) {
                answer = (answer == 0) ? tile.getId() : answer * tile.getId();
            }
        }

        System.out.println(answer);
        return 0;
    }
}
