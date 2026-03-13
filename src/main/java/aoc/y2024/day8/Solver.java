package aoc.y2024.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;
import aoc.utils.Pair;
import aoc.utils.geometry.Point;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract HashSet<Point> createAntinodes(List<Pair<Point>> pairs, Grid grid);

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var frequencies = getFrequencies(grid);
        var pairs = getPairs(frequencies);
        var nodes = createAntinodes(pairs, grid);

        return nodes.size();
    }

    private void addFrequency(HashMap<Character, List<Point>> map, char key, Point pt) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Point>());
        }

        map.get(key).add(pt);
    }

    private HashMap<Character, List<Point>> getFrequencies(Grid grid) {
        var frequencies = new HashMap<Character, List<Point>>();

        for (var row = 0; row < grid.getRows(); row += 1) {
            for (var col = 0; col < grid.getCols(); col += 1) {
                var ch = grid.get(row, col);

                if (ch != '.') {
                    addFrequency(frequencies, ch, new Point(row, col));
                }
            }
        }

        return frequencies;
    }

    private List<Pair<Point>> pairsFromList(List<Point> pts) {
        var pairs = new ArrayList<Pair<Point>>();

        for (var start = 0; start < pts.size() - 1; start += 1) {
            for (var index = start + 1; index < pts.size(); index += 1) {
                pairs.add(new Pair<Point>(pts.get(start), pts.get(index)));
            }
        }

        return pairs;
    }

    private List<Pair<Point>> getPairs(HashMap<Character, List<Point>> map) {
        var pairs = new ArrayList<Pair<Point>>();

        for (var pts : map.values()) {
            pairs.addAll(pairsFromList(pts));
        }

        return pairs;
    }
}
