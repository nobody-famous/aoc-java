package aoc.y2024.day8;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Grid;
import aoc.utils.Pair;
import aoc.utils.geometry.Point;

public class Part1 extends Solver {
    @Override
    protected HashSet<Point> createAntinodes(List<Pair<Point>> pairs, Grid grid) {
        var nodes = new HashSet<Point>();

        for (var pair : pairs) {
            var rowDiff = pair.left().x - pair.right().x;
            var colDiff = pair.left().y - pair.right().y;

            var node1 = new Point(pair.left().x + rowDiff, pair.left().y + colDiff);
            var node2 = new Point(pair.right().x - rowDiff, pair.right().y - colDiff);

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
