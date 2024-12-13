package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Rules {
    private HashMap<Integer, HashSet<Integer>> orderings = new HashMap<>();
    private List<List<Integer>> updates = new ArrayList<>();

    public void addOrdering(int before, int after) {
        if (!orderings.containsKey(before)) {
            orderings.put(before, new HashSet<Integer>());
        }

        orderings.get(before).add(after);
    }

    public void addUpdate(List<Integer> update) {
        updates.add(update);
    }

    public HashMap<Integer, HashSet<Integer>> getOrderings() {
        return orderings;
    }

    public List<List<Integer>> getUpdates() {
        return updates;
    }
}
