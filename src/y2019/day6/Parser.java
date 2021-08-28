package y2019.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser extends utils.Parser<Map<String, List<String>>> {
    public Parser(String fileName) {
        super(fileName);
    }

    private void addToMap(Map<String, List<String>> orbits, String parent, String child) {
        if (!orbits.containsKey(parent)) {
            orbits.put(parent, new ArrayList<String>());
        }

        var kids = orbits.get(parent);

        kids.add(child);
    }

    public Map<String, List<String>> parse() {
        try {
            var lines = readLines();
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
