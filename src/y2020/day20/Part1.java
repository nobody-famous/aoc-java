package y2020.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Problem;

public class Part1 implements Problem {
    private Tile[] input;

    public Part1(Tile[] input) {
        this.input = input;
    }

    private List<Tile> permutations(Tile tile) {
        var perms = new ArrayList<Tile>();
        var curr = tile;

        for (var loop = 0; loop < 4; loop += 1) {
            perms.add(curr);
            perms.add(curr.flip());

            curr = curr.rotate();
        }

        return perms;
    }

    public long solve() {
        var tiles = new HashMap<Integer, List<Tile>>();

        for (var tile : input) {
            tiles.put(tile.getId(), permutations(tile));
        }

        System.out.println(input[0]);
        System.out.println(input[0].rotate());

        return 0;
    }
}
