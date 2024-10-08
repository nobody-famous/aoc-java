package aoc.y2019.day24;

import java.util.List;

public class Parser extends aoc.utils.Parser<Grid> {
    @Override
    public Grid parse(List<String> lines) {
        try {
            var grid = new Grid();

            for (var y = 0; y < lines.size(); y += 1) {
                var line = lines.get(y);

                for (var x = 0; x < line.length(); x += 1) {
                    var cell = line.charAt(x) == '#' ? Grid.BUG : Grid.EMPTY;

                    grid.set(x, y, cell);
                }
            }

            return grid;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
