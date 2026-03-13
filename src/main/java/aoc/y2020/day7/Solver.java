package aoc.y2020.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    protected Map<String, List<BagContents>> rulesToMap(List<BagRule> rules) {
        var out = new HashMap<String, List<BagContents>>();

        for (var rule : rules) {
            out.put(rule.type(), rule.contents());
        }

        return out;
    }
}
