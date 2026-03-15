package aoc.y2020.day20;

import java.util.List;

public class Part1 extends Solver {
    @Override
    public Long solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var tiles = tilePerms(input);
        var borders = bordersMap(tiles);
        var answer = 0L;

        for (var tile : input) {
            var count = countMatches(borders, tile);

            if (count == 2) {
                answer = (answer == 0) ? tile.getId() : answer * tile.getId();
            }
        }

        return answer;
    }
}
