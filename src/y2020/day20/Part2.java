package y2020.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    private Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
    private Map<String, Integer> borderCounts;

    private String[] monster = new String[] { "                  # ", "#    ##    ##    ###", " #  #  #  #  #  #   " };
    private int numMonsterPoints;

    public Part2(Tile[] input, long expected) {
        super(input, expected);

        numMonsterPoints = countPounds(monster);
    }

    private int countPounds(String[] data) {
        var count = 0;

        for (var row = 0; row < data.length; row += 1) {
            for (var ch : data[row].toCharArray()) {
                if (ch == '#') {
                    count += 1;
                }
            }
        }

        return count;
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

    private Tile[][] placeTiles(Map<Integer, List<Tile>> tiles) {
        var size = (int) Math.sqrt(input.length);
        var grid = new Tile[size][size];
        var corner = getCandidate(tiles, null, null);

        used.put(corner.getId(), true);
        grid[0][0] = corner;

        for (var row = 0; row < size; row += 1) {
            for (var col = 0; col < size; col += 1) {
                if (grid[row][col] != null) {
                    continue;
                }

                var north = (row > 0) ? grid[row - 1][col].getBorder(Tile.SOUTH) : null;
                var east = (col > 0) ? grid[row][col - 1].getBorder(Tile.EAST) : null;
                var tile = findMatch(tiles, north, east);

                if (tile == null) {
                    throw new RuntimeException("Failed to place " + row + "," + col);
                }

                used.put(tile.getId(), true);
                grid[row][col] = tile;
            }
        }

        return grid;
    }

    private int tileWidth(Tile tile) {
        var data = tile.getData();
        var row = data[0];

        return row.length();
    }

    private void bitBlit(char[][] canvas, int startRow, int startCol, Tile tile) {
        var data = tile.getData();
        var rowNdx = startRow;
        var colNdx = startCol;

        for (var dataRow = 1; dataRow < data[0].length() - 1; dataRow += 1) {
            var row = data[dataRow].toCharArray();

            for (var dataCol = 1; dataCol < data[0].length() - 1; dataCol += 1) {
                canvas[rowNdx][colNdx] = row[dataCol];
                colNdx += 1;
            }

            colNdx = startCol;
            rowNdx += 1;
        }
    }

    private Tile gridToTile(Tile[][] grid) {
        var tileSize = tileWidth(grid[0][0]) - 2;
        var size = tileSize * grid.length;
        var canvas = new char[size][size];

        for (var row = 0; row < grid.length; row += 1) {
            for (var col = 0; col < grid.length; col += 1) {
                bitBlit(canvas, row * tileSize, col * tileSize, grid[row][col]);
            }
        }

        var data = new String[canvas.length];
        for (var row = 0; row < canvas.length; row += 1) {
            data[row] = new String(canvas[row]);
        }

        return new Tile(-1, data);
    }

    private List<Point> monsterPoints() {
        var points = new ArrayList<Point>();

        for (var row = 0; row < monster.length; row += 1) {
            var charArray = monster[row].toCharArray();

            for (var col = 0; col < charArray.length; col += 1) {
                if (charArray[col] == '#') {
                    points.add(new Point(row, col));
                }
            }
        }

        return points;
    }

    private boolean matchMonster(Tile tile, List<Point> points, int startRow, int startCol) {
        var data = tile.getData();

        for (var point : points) {
            var row = startRow + point.getRow();
            var col = startCol + point.getCol();

            if (data[row].charAt(col) != '#') {
                return false;
            }
        }

        return true;
    }

    private int countMonsters(Tile tile) {
        var data = tile.getData();
        var points = monsterPoints();
        var count = 0;

        for (var row = 0; row < data.length - monster.length; row += 1) {
            for (var col = 0; col < data.length - monster[0].length(); col += 1) {
                if (matchMonster(tile, points, row, col)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public Long run() {
        var answer = 0L;
        var tiles = tilePerms(input);

        borderCounts = bordersMap(tiles);

        var grid = placeTiles(tiles);
        var tile = gridToTile(grid);
        var perms = permutations(tile);

        var monsterCount = 0;
        for (var perm : perms) {
            monsterCount = countMonsters(perm);
            if (monsterCount > 0) {
                break;
            }
        }

        var pounds = countPounds(tile.getData());

        answer = pounds - (monsterCount * numMonsterPoints);

        return answer;
    }
}
