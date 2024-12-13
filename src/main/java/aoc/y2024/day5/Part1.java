package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public List<List<Integer>> findUpdates(PageComparator cmp, List<List<Integer>> updates) {
        var found = new ArrayList<List<Integer>>();

        for (var update : updates) {
            if (isInOrder(cmp, update)) {
                found.add(update);
            }
        }

        return found;
    }
}
