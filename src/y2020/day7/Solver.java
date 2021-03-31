package y2020.day7;

import java.util.HashMap;
import java.util.Map;

public abstract class Solver {
    protected Map<String, BagContents[]> rulesToMap(BagRule[] rules) {
        var out = new HashMap<String, BagContents[]>();

        for (var rule : rules) {
            out.put(rule.getType(), rule.getContents());
        }

        return out;
    }
}
