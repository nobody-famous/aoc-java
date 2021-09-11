package y2019.day14;

import java.util.HashMap;
import java.util.Map;

import utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Map<String, Reaction> reactions;
    private Parser parser;

    public Solver(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    abstract long doWork();

    public Long run() {
        reactions = parser.parse();
        return doWork();
    }

    public long getOreForFuel(long fuel) {
        var pile = new HashMap<String, Long>();
        Map<String, Long> level = new HashMap<String, Long>();

        level.put("FUEL", fuel);
        do {
            level = getNextLevel(pile, level);
        } while (level.size() > 1);

        return level.get("ORE");
    }

    private void addToMap(Map<String, Long> dict, String name, long amount) {
        var existing = dict.containsKey(name) ? dict.get(name) : 0;

        dict.put(name, existing + amount);
    }

    private long getMultiplier(long need, long make) {
        return need % make == 0 ? need / make : (need / make) + 1;
    }

    private Map<String, Long> getChemicals(Map<String, Long> pile, String name, long reqAmount) {
        var react = reactions.get(name);
        var chems = new HashMap<String, Long>();
        var mult = getMultiplier(reqAmount, react.output().amount());
        var rem = (react.output().amount() * mult) - reqAmount;

        if (rem > 0) {
            addToMap(pile, name, rem);
        }

        for (var chem : react.input()) {
            chems.put(chem.name(), (long) chem.amount() * mult);
        }

        return chems;
    }

    private long getFromPile(Map<String, Long> pile, String name, long amount) {
        if (!pile.containsKey(name)) {
            return amount;
        }

        var inPile = pile.get(name);

        if (inPile == amount) {
            pile.remove(name);
            return 0;
        } else if (inPile > amount) {
            addToMap(pile, name, (long) -amount);
            return 0;
        }

        pile.remove(name);

        return amount - inPile;
    }

    private Map<String, Long> getNextLevel(Map<String, Long> pile, Map<String, Long> curLevel) {
        var nextLevel = new HashMap<String, Long>();

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
}
