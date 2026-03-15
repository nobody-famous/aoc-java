package aoc.y2020.day24;

import java.util.ArrayList;
import java.util.List;

public class Parser implements aoc.utils.Parser<List<List<Direction>>> {
    @Override
    public List<List<Direction>> parse(List<String> lines) {
        var tiles = new ArrayList<List<Direction>>();

        for (var index = 0; index < lines.size(); index++) {
            var line = lines.get(index);
            var tile = new ArrayList<Direction>();

            for (var ndx = 0; ndx < line.length(); ndx++) {
                if (line.charAt(ndx) == 'e') {
                    tile.add(Direction.EAST);
                } else if (line.charAt(ndx) == 'w') {
                    tile.add(Direction.WEST);
                } else if (line.charAt(ndx) == 'n' && line.charAt(ndx + 1) == 'e') {
                    tile.add(Direction.NORTHEAST);
                    ndx++;
                } else if (line.charAt(ndx) == 'n' && line.charAt(ndx + 1) == 'w') {
                    tile.add(Direction.NORTHWEST);
                    ndx++;
                } else if (line.charAt(ndx) == 's' && line.charAt(ndx + 1) == 'e') {
                    tile.add(Direction.SOUTHEAST);
                    ndx++;
                } else if (line.charAt(ndx) == 's' && line.charAt(ndx + 1) == 'w') {
                    tile.add(Direction.SOUTHWEST);
                    ndx++;
                }
            }

            tiles.add(tile);
        }

        return tiles;
    }
}
