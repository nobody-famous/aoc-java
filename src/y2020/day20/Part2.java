package y2020.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    public Part2(Tile[] input) {
        super(input);
    }

    private List<Tile> getCandidates(Map<Integer, List<Tile>> tilesMap, String target, int id, int direction) {
        var candidates = new ArrayList<Tile>();

        for (var entry : tilesMap.entrySet()) {
            var entryID = entry.getKey();
            var tiles = entry.getValue();

            if (entryID == id) {
                continue;
            }

            for (var tile : tiles) {
                var border = tile.getBorder(direction);

                if (target.equals(border)) {
                    candidates.add(tile);
                }
            }
        }

        return candidates;
    }

    private Tile findMatch(Map<Integer, List<Tile>> tilesMap, int ignoreID, String northTarget, String westTarget) {
        for (var tiles : tilesMap.values()) {
            for (var tile : tiles) {
                if (tile.getId() == ignoreID) {
                    continue;
                }

                var northList = getCandidates(tilesMap, tile.getBorder(Tile.NORTH), tile.getId(), Tile.SOUTH);
                var westList = getCandidates(tilesMap, tile.getBorder(Tile.WEST), tile.getId(), Tile.EAST);

                if (northList.size() > 1 || westList.size() > 1) {
                    throw new RuntimeException("Too many candidates " + northList.size() + " " + westList.size());
                }

                var north = northList.size() > 0 ? northList.get(0).getBorder(Tile.SOUTH) : null;
                var west = westList.size() > 0 ? westList.get(0).getBorder(Tile.EAST) : null;

                var matchNorth = false;
                var matchWest = false;

                if ((north == null && northTarget == null) || (north != null && north.equals(northTarget))) {
                    matchNorth = true;
                }

                if ((west == null && westTarget == null) || (west != null && west.equals(westTarget))) {
                    matchWest = true;
                }

                if (matchNorth && matchWest) {
                    return tile;
                }
            }
        }

        return null;

    }

    public long solve() {
        var tiles = tilePerms(input);

        var corner = findMatch(tiles, -1, null, null);
        System.out.println(corner);

        var perm = findMatch(tiles, corner.getId(), null, corner.getBorder(Tile.EAST));
        System.out.println();
        System.out.println(perm);

        perm = findMatch(tiles, perm.getId(), null, perm.getBorder(Tile.EAST));
        System.out.println();
        System.out.println(perm);

        perm = findMatch(tiles, corner.getId(), corner.getBorder(Tile.SOUTH), null);
        System.out.println();
        System.out.println(perm);

        return 0;
    }
}
