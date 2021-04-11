package y2020.day20;

public class Part1 extends Solver {
    public Part1(Tile[] input) {
        super(input);
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
