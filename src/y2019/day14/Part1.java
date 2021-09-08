package y2019.day14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private Set<String> getFromOre(Map<String, Reaction> reactions) {
        var fromOre = new HashSet<String>();

        for (var entry : reactions.entrySet()) {
            var react = entry.getValue();

            if (react.input().size() == 1 && react.input().get(0).name().equals("ORE")) {
                fromOre.add(entry.getKey());
            }
        }

        return fromOre;
    }

    private Map<String, Integer> updateNeeded(Map<String, Reaction> react, Map<String, Integer> old) {
        var needed = new HashMap<String, Integer>();

        for (var entry : old.entrySet()) {
            if (entry.getKey().equals("ORE")) {
                needed.put(entry.getKey(), entry.getValue());
                continue;
            }

            var target = react.get(entry.getKey());

            for (var chem : target.input()) {
                var existing = needed.containsKey(chem.name()) ? needed.get(chem.name()) : 0;
                var amount = existing + chem.amount();

                needed.put(chem.name(), amount);
            }
        }

        return needed;
    }

    public Integer run() {
        var reactions = parser.parse();
        var fromOre = getFromOre(reactions);
        Map<String, Integer> needed = new HashMap<String, Integer>();

        needed.put("FUEL", reactions.get("FUEL").output().amount());

        needed = updateNeeded(reactions, needed);

        System.out.println("fromOre" + fromOre);
        System.out.println("Needed " + needed);

        return 0;
    }
}
