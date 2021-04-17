package y2020.day7;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected BagRule[] input;

    protected Solver(BagRule[] input, long expected) {
        super(expected);
        this.input = input;
    }

    protected Map<String, BagContents[]> rulesToMap(BagRule[] rules) {
        var out = new HashMap<String, BagContents[]>();

        for (var rule : rules) {
            out.put(rule.getType(), rule.getContents());
        }

        return out;
    }
}
