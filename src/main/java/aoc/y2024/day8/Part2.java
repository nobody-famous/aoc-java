package aoc.y2024.day8;

import java.util.HashSet;
import java.util.List;

import aoc.utils.Grid;
import aoc.utils.Pair;
import aoc.utils.geometry.Point;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected HashSet<Point> createAntinodes(List<Pair<Point>> pairs, Grid grid) {
        var nodes = new HashSet<Point>();

        for (var pair : pairs) {
            var rowDiff = pair.left().x - pair.right().x;
            var colDiff = pair.left().y - pair.right().y;
            var pt = new Point(pair.left());

            while (grid.onMap(pt)) {
                nodes.add(new Point(pt));
                pt.inc(rowDiff, colDiff);
            }

            pt = new Point(pair.left());
            while (grid.onMap(pt)) {
                nodes.add(new Point(pt)); 
                pt.inc(-rowDiff, -colDiff);
            }
        }

        return nodes;
    }
}
