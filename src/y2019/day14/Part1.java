package y2019.day14;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private Map<String, Reaction> reactions;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    private void addToMap(Map<String, Integer> dict, String name, int amount) {
        var existing = dict.containsKey(name) ? dict.get(name) : 0;

        dict.put(name, existing + amount);
    }

    private int getMultiplier(int need, int make) {
        return need % make == 0 ? need / make : (need / make) + 1;
    }

    private Map<String, Integer> getChemicals(Map<String, Integer> pile, String name, int reqAmount) {
        var react = reactions.get(name);
        var chems = new HashMap<String, Integer>();
        var mult = getMultiplier(reqAmount, react.output().amount());
        var rem = (react.output().amount() * mult) - reqAmount;

        if (rem > 0) {
            addToMap(pile, name, rem);
        }

        for (var chem : react.input()) {
            chems.put(chem.name(), chem.amount() * mult);
        }

        return chems;
    }

    private int getFromPile(Map<String, Integer> pile, String name, int amount) {
        if (!pile.containsKey(name)) {
            return amount;
        }

        var inPile = pile.get(name);

        if (inPile == amount) {
            pile.remove(name);
            return 0;
        } else if (inPile > amount) {
            addToMap(pile, name, -amount);
            return 0;
        }

        pile.remove(name);

        return amount - inPile;
    }

    private Map<String, Integer> getNextLevel(Map<String, Integer> pile, Map<String, Integer> curLevel) {
        var nextLevel = new HashMap<String, Integer>();

        for (var chem : curLevel.entrySet()) {
            if ("ORE".equals(chem.getKey())) {
                addToMap(nextLevel, chem.getKey(), chem.getValue());
                continue;
            }

            var toGet = getFromPile(pile, chem.getKey(), chem.getValue());
            var kids = getChemicals(pile, chem.getKey(), toGet);

            for (var kid : kids.entrySet()) {
                addToMap(nextLevel, kid.getKey(), kid.getValue());
            }
        }

        return nextLevel;
    }

    public Integer run() {
        reactions = parser.parse();
        var pile = new HashMap<String, Integer>();
        Map<String, Integer> level = new HashMap<String, Integer>();

        level.put("FUEL", 1);
        do {
            level = getNextLevel(pile, level);
        } while (level.size() > 1);

        return level.get("ORE");
    }
}
