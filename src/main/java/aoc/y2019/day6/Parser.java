package aoc.y2019.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser extends aoc.utils.Parser<Map<String, List<String>>> {
    private void addToMap(Map<String, List<String>> orbits, String parent, String child) {
        if (!orbits.containsKey(parent)) {
            orbits.put(parent, new ArrayList<String>());
        }

        var kids = orbits.get(parent);

        kids.add(child);
    }

    @Override
    public Map<String, List<String>> parse(List<String> lines) {
        try {
            var orbits = new HashMap<String, List<String>>();

            for (var line : lines) {
                var parts = line.split("\\)");

                addToMap(orbits, parts[0], parts[1]);
            }

            return orbits;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
