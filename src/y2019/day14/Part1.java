package y2019.day14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private Map<String, Reaction> reactions;
    private Map<String, Integer> stockPile;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
        stockPile = new HashMap<>();
    }

    private Set<String> getFromOre() {
        var fromOre = new HashSet<String>();

        for (var entry : reactions.entrySet()) {
            var react = entry.getValue();

            if (react.input().size() == 1 && react.input().get(0).name().equals("ORE")) {
                fromOre.add(entry.getKey());
            }
        }

        return fromOre;
    }

    private void addToMap(Map<String, Integer> dict, String name, int amount) {
        var existing = dict.containsKey(name) ? dict.get(name) : 0;

        dict.put(name, existing + amount);
    }

    private Map<String, Integer> updateNeeded(Map<String, Integer> old) {
        var needed = new HashMap<String, Integer>();

        for (var entry : old.entrySet()) {
            var name = entry.getKey();
            var quantity = entry.getValue();

            if ("ORE".equals(name)) {
                addToMap(needed, name, quantity);
                continue;
            }

            var reaction = reactions.get(name);
            // var toMake = quantity <= reaction.output().amount() ? 1 : quantity / reaction.output().amount();
            var need = reaction.output().amount();
            var toMake = quantity % need == 0 ? quantity / need : (quantity / need) + 1;
            var leftOver = (toMake * need) - quantity;

            addToMap(stockPile, name, leftOver);

            for (var chem : reaction.input()) {
                var fromPile = stockPile.containsKey(chem.name()) ? stockPile.get(chem.name()) : 0;
                var toAdd = toMake * chem.amount();

                if (fromPile == toAdd) {
                    stockPile.remove(chem.name());
                    continue;
                } else if (fromPile > toAdd) {
                    addToMap(stockPile, chem.name(), -toAdd);
                    continue;
                } else {
                    toAdd -= fromPile;
                    stockPile.remove(chem.name());
                }

                addToMap(needed, chem.name(), toAdd);
            }
        }

        return needed;
    }

    private boolean onlyOre(Map<String, Integer> needed) {
        for (var entry : needed.entrySet()) {
            if (!entry.getKey().equals("ORE")) {
                return false;
            }
        }

        return true;
    }

    public Integer run() {
        reactions = parser.parse();

        var needed = (Map<String, Integer>) new HashMap<String, Integer>();

        needed.put("FUEL", reactions.get("FUEL").output().amount());

        while (!onlyOre(needed)) {
            needed = updateNeeded(needed);
            System.out.println(needed);
        }

        System.out.println("Needed " + needed);

        return needed.get("ORE");
    }
}
