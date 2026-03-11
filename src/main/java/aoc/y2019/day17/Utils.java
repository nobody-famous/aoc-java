package aoc.y2019.day17;

import java.util.HashSet;
import java.util.Set;

import aoc.utils.Grid;
import aoc.utils.geometry.Point;

public class Utils {
    public static Set<Point> buildScaffold(Grid grid) {
        var scaffold = new HashSet<Point>();

        for (var row = 0; row < grid.getRows(); row++) {
            for (var col = 0; col < grid.getCols(); col++) {
                var ch = grid.get(row, col);

                switch (ch) {
                case '#':
                case '^':
                case 'v':
                case '<':
                case '>':
                    scaffold.add(new Point(col, row));
                    break;
                }
            }
        }

        return scaffold;
    }
}
