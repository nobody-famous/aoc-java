package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    List<List<Integer>> findUpdates(PageComparator cmp, List<List<Integer>> updates) {
        var toSort = findToSort(cmp, updates);

        for (var update : toSort) {
            update.sort(cmp);
        }

        return toSort;
    }

    private List<List<Integer>> findToSort(PageComparator cmp, List<List<Integer>> updates) {
        var toSort = new ArrayList<List<Integer>>();

        for (var update : updates) {
            if (!isInOrder(cmp, update)) {
                toSort.add(update);
            }
        }

        return toSort;
    }
}
