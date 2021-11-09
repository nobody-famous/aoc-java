package aoc.y2020.day20;

public class Part1 extends Solver {
    public Part1(Tile[] input, long expected) {
        super(input, expected);
    }

    public Long run() {
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
