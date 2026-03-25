package aoc.y2024.day8;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Grid;
import aoc.utils.Pair;

public class Part2 extends Solver {
    @Override
    protected HashSet<Grid.Loc> createAntinodes(List<Pair<Grid.Loc>> pairs, Grid grid) {
        var nodes = new HashSet<Grid.Loc>();

        for (var pair : pairs) {
            var rowDiff = pair.left().row() - pair.right().row();
            var colDiff = pair.left().col() - pair.right().col();
            var loc = new Grid.Loc(pair.left());

            while (grid.onMap(loc)) {
                nodes.add(new Grid.Loc(loc));
                loc = new Grid.Loc(loc.row() + rowDiff, loc.col() + colDiff);
            }

            loc = new Grid.Loc(pair.left());
            while (grid.onMap(loc)) {
                nodes.add(new Grid.Loc(loc));
                loc = new Grid.Loc(loc.row() - rowDiff, loc.col() - colDiff);
            }
        }

        return nodes;
    }
}
