package y2019.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Problem;

public class Part1 extends Problem<Integer> {
    private Parser parser;
    private Map<String, Reaction> reactions;

    public Part1(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
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

    private void visit(Map<String, Integer> required, Map<String, Integer> pile, List<String> path, String name,
            int mx) {
        var react = reactions.get(name);

        if (react == null) {
            return;
        }

        for (var child : react.input()) {
            var childReact = reactions.get(child.name());

            if (childReact == null) {
                continue;
            }

            var need = child.amount() * mx;
            var make = childReact.output().amount();
            var mult = getMultiplier(need, make);
            var rem = (make * mult) - need;

            if (rem > 0) {
                addToMap(pile, child.name(), rem);
            }

            addToMap(required, child.name(), need);

            visit(required, pile, path, child.name(), mult);
        }
    }

    private int getMultiplier(int need, int make) {
        return need % make == 0 ? need / make : (need / make) + 1;
    }

    private List<String> buildPath() {
        var path = new ArrayList<String>();
        var fromOre = getFromOre();
        var required = new HashMap<String, Integer>();
        var pile = new HashMap<String, Integer>();

        visit(required, pile, path, "FUEL", 1);

        var total = 0;
        for (var name : fromOre) {
            var react = reactions.get(name);
            var fromPile = pile.containsKey(name) ? pile.get(name) : 0;
            var req = required.get(name) - fromPile;
            var ore = react.input().get(0).amount();
            var mult = getMultiplier(req, react.output().amount());

            total += (ore * mult);
        }

        System.out.println("total ore " + total);

        return path;
    }

    public Integer run() {
        reactions = parser.parse();

        var path = buildPath();
        System.out.println("path " + path);

        // var needed = (Map<String, Integer>) new HashMap<String, Integer>();

        // needed.put("FUEL", reactions.get("FUEL").output().amount());

        // while (!onlyOre(needed)) {
        //     needed = updateNeeded(needed);
        //     System.out.println(needed);
        // }

        // System.out.println("Needed " + needed);

        // return needed.get("ORE");

        return 0;
    }
}
