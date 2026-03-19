package aoc.y2024.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;
import aoc.utils.Pair;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract HashSet<Grid.Loc> createAntinodes(List<Pair<Grid.Loc>> pairs, Grid grid);

    @Override
    public Integer solve(List<String> lines) {
        var grid = Grid.parse(lines);
        var frequencies = getFrequencies(grid);
        var pairs = getPairs(frequencies);
        var nodes = createAntinodes(pairs, grid);

        return nodes.size();
    }

    private void addFrequency(HashMap<Character, List<Grid.Loc>> map, char key, Grid.Loc loc) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Grid.Loc>());
        }

        map.get(key).add(loc);
    }

    private HashMap<Character, List<Grid.Loc>> getFrequencies(Grid grid) {
        var frequencies = new HashMap<Character, List<Grid.Loc>>();

        for (var row = 0; row < grid.getRows(); row += 1) {
            for (var col = 0; col < grid.getCols(); col += 1) {
                var ch = grid.get(row, col);

                if (ch != '.') {
                    addFrequency(frequencies, ch, new Grid.Loc(row, col));
                }
            }
        }

        return frequencies;
    }

    private List<Pair<Grid.Loc>> pairsFromList(List<Grid.Loc> locs) {
        var pairs = new ArrayList<Pair<Grid.Loc>>();

        for (var start = 0; start < locs.size() - 1; start += 1) {
            for (var index = start + 1; index < locs.size(); index += 1) {
                pairs.add(new Pair<Grid.Loc>(locs.get(start), locs.get(index)));
            }
        }

        return pairs;
    }

    private List<Pair<Grid.Loc>> getPairs(HashMap<Character, List<Grid.Loc>> map) {
        var pairs = new ArrayList<Pair<Grid.Loc>>();

        for (var pts : map.values()) {
            pairs.addAll(pairsFromList(pts));
        }

        return pairs;
    }
}
