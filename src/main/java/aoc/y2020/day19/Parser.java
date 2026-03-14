package aoc.y2020.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser implements aoc.utils.Parser<Notes> {
    @Override
    public Notes parse(List<String> lines) {
        var rulesMap = new HashMap<Integer, Rule>();
        var messages = new ArrayList<String>();
        var inRules = true;

        for (var line : lines) {
            if (line.trim().length() == 0) {
                inRules = false;
                continue;
            }

            if (inRules) {
                parseRule(rulesMap, line);
            } else {
                messages.add(line);
            }
        }

        var rules = rulesMap.entrySet().stream().sorted((a, b) -> a.getKey() > b.getKey() ? 1 : -1).map(e -> e.getValue()).collect(Collectors.toCollection(ArrayList::new));

        return new Notes(rules, messages);
    }

    private void parseRule(Map<Integer, Rule> rules, String line) {
        var parts = line.split(":");
        var number = Integer.parseInt(parts[0].trim());

        if (parts[1].contains("|")) {
            rules.put(number, parseOrRule(parts[1].trim()));
        } else if (parts[1].contains("\"")) {
            rules.put(number, parseCharRule(parts[1].trim()));
        } else {
            rules.put(number, parseAndRule(parts[1].trim()));
        }
    }

    private OrRule parseOrRule(String input) {
        var parts = input.split("\\|");

        return new OrRule(parseAndRule(parts[0].trim()), parseAndRule(parts[1].trim()));
    }

    private AndRule parseAndRule(String input) {
        return new AndRule(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    private CharRule parseCharRule(String input) {
        if (input.charAt(0) != '"' && input.charAt(2) != '"') {
            throw new RuntimeException("Invalid char rule: " + input);
        }

        return new CharRule(input.charAt(1));
    }
}
