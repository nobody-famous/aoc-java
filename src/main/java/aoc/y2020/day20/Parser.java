package aoc.y2020.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<Tile>> {
    private static final Pattern tilePattern = Pattern.compile("Tile (\\d+):");
    private static final Matcher tileMatcher = tilePattern.matcher("");

    @Override
    public List<Tile> parse(List<String> lines) {
        var tiles = new ArrayList<Tile>();
        var id = -1;
        var data = new ArrayList<String>();

        for (var line : lines) {
            if (line.trim().length() == 0) {
                tiles.add(new Tile(id, data.toArray(new String[]{})));
                id = -1;
                data = new ArrayList<String>();
                continue;
            }

            tileMatcher.reset(line);
            if (tileMatcher.matches()) {
                id = Integer.parseInt(tileMatcher.group(1));
                continue;
            }

            data.add(line);
        }

        if (id >= 0) {
            tiles.add(new Tile(id, data.toArray(new String[]{})));
        }

        return tiles;
    }
}
