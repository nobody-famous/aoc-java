package y2020.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    private Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
    private Map<String, Integer> borderCounts;

    public Part2(Tile[] input) {
        super(input);
    }

    private List<Tile> getCandidates(Map<Integer, List<Tile>> tilesMap, String north, String west) {
        var candidates = new HashMap<Integer, Tile>();

        for (var entry : tilesMap.entrySet()) {
            var tiles = entry.getValue();

            if (used.containsKey(entry.getKey())) {
                continue;
            }

            for (var tile : tiles) {
                var northBorder = tile.getBorder(Tile.NORTH);
                var westBorder = tile.getBorder(Tile.WEST);
                var matchNorth = false;
                var matchWest = false;

                if ((north == null && borderCounts.get(northBorder) == 4)
                        || (north != null && north.equals(northBorder))) {
                    matchNorth = true;
                }

                if ((west == null && borderCounts.get(westBorder) == 4) || (west != null && west.equals(westBorder))) {
                    matchWest = true;
                }

                if (matchNorth && matchWest) {
                    candidates.put(tile.getId(), tile);
                }
            }
        }

        var tiles = new ArrayList<Tile>();
        for (var tile : candidates.values()) {
            tiles.add(tile);
        }

        return tiles;
    }

    private Tile findMatch(Map<Integer, List<Tile>> tilesMap, String northTarget, String westTarget) {
        for (var entry : tilesMap.entrySet()) {
            var tileID = entry.getKey();
            var tiles = entry.getValue();

            if (used.containsKey(tileID)) {
                continue;
            }

            // for (var tile : tiles) {
            var northList = getCandidates(tilesMap, northTarget, westTarget);
            // var westList = getCandidates(tilesMap, used, westTarget, Tile.WEST);

            if (northList.size() > 1) {
                for (var tile : northList) {
                    System.out.println(tile.getId());
                }
                throw new RuntimeException("Too many candidates " + northList.size());
            }

            return northList.get(0);
            // var north = northList.size() > 0 ? northList.get(0).getBorder(Tile.SOUTH) : null;
            // var west = westList.size() > 0 ? westList.get(0).getBorder(Tile.EAST) : null;

            // var matchNorth = false;
            // var matchWest = false;

            // if ((north == null && northTarget == null) || (north != null && north.equals(northTarget))) {
            // matchNorth = true;

            // }

            // if ((west == null && westTarget == null) || (west != null && west.equals(westTarget))) {
            //     matchWest = true;
            // }

            // if (matchNorth && matchWest) {
            //     return tile;
            // }
            // }
        }

        return null;

    }

    public long solve() {
        var size = (int) Math.sqrt(input.length);
        var grid = new Tile[size][size];
        var tiles = tilePerms(input);

        borderCounts = bordersMap(tiles);

        var corners = getCandidates(tiles, null, null);

        grid[0][0] = corners.get(0);
        used.put(grid[0][0].getId(), true);

        for (var row = 0; row < size; row += 1) {
            for (var col = 0; col < size; col += 1) {
                if (grid[row][col] != null) {
                    continue;
                }

                var north = (col > 0) ? grid[row][col - 1].getBorder(Tile.SOUTH) : null;
                var east = (row > 0) ? grid[row - 1][col].getBorder(Tile.EAST) : null;
                var tile = findMatch(tiles, north, east);

                if (tile == null) {
                    throw new RuntimeException("Failed to place " + row + "," + col);
                }

                used.put(tile.getId(), true);
                grid[row][col] = tile;
            }
        }

        for (var row = 0; row < size; row += 1) {
            for (var col = 0; col < size; col += 1) {
                System.out.print(grid[row][col].getId() + " ");
            }
            System.out.println();
        }
        return 0;
    }
}
