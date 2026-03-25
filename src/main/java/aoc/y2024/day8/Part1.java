package aoc.y2024.day8;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Grid;
import aoc.utils.Pair;

public class Part1 extends Solver {
    @Override
    protected HashSet<Grid.Loc> createAntinodes(List<Pair<Grid.Loc>> pairs, Grid grid) {
        var nodes = new HashSet<Grid.Loc>();

        for (var pair : pairs) {
            var rowDiff = pair.left().row() - pair.right().row();
            var colDiff = pair.left().col() - pair.right().col();

            var node1 = new Grid.Loc(pair.left().row() + rowDiff, pair.left().col() + colDiff);
            var node2 = new Grid.Loc(pair.right().row() - rowDiff, pair.right().col() - colDiff);

            if (grid.onMap(node1)) {
                nodes.add(node1);
            }

            if (grid.onMap(node2)) {
                nodes.add(node2);
            }
        }

        return nodes;
    }
}
