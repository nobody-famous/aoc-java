package y2020.day20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    private Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
    private Map<String, Integer> borderCounts;

    public Part2(Tile[] input) {
        super(input);
    }

    private boolean isEdge(String border) {
        return borderCounts.get(border) == 4;
    }

    private boolean edgeMatches(String first, String second) {
        return ((first == null && isEdge(second)) || (first != null && first.equals(second)));
    }

    private Tile getCandidate(Map<Integer, List<Tile>> tilesMap, String north, String west) {
        for (var entry : tilesMap.entrySet()) {
            var tiles = entry.getValue();

            if (used.containsKey(entry.getKey())) {
                continue;
            }

            for (var tile : tiles) {
                var northBorder = tile.getBorder(Tile.NORTH);
                var westBorder = tile.getBorder(Tile.WEST);

                if (edgeMatches(north, northBorder) && edgeMatches(west, westBorder)) {
                    return tile;
                }
            }
        }

        return null;
    }

    private Tile findMatch(Map<Integer, List<Tile>> tilesMap, String northTarget, String westTarget) {
        for (var entry : tilesMap.entrySet()) {
            var tileID = entry.getKey();

            if (used.containsKey(tileID)) {
                continue;
            }

            return getCandidate(tilesMap, northTarget, westTarget);
        }

        return null;

    }

    public long solve() {
        var size = (int) Math.sqrt(input.length);
        var grid = new Tile[size][size];
        var tiles = tilePerms(input);

        borderCounts = bordersMap(tiles);

        var corner = getCandidate(tiles, null, null);

        used.put(corner.getId(), true);
        grid[0][0] = corner;

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
