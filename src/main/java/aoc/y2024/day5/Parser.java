package aoc.y2024.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<Rules> {
    private final Pattern orderingPattern = Pattern.compile("(\\d+)\\|(\\d+)");
    private final Matcher orderingMatcher = orderingPattern.matcher("");
    private final Pattern updatePattern = Pattern.compile("(\\d+),?");
    private final Matcher updateMatcher = updatePattern.matcher("");

    @Override
    public Rules parse(List<String> lines) {
        var rules = new Rules();
        boolean parsingOrderings = true;

        for (var line : lines) {
            if (line.length() == 0) {
                parsingOrderings = false;
            } else if (parsingOrderings) {
                parseOrdering(rules, line);
            } else {
                parseUpdate(rules, line);
            }
        }

        return rules;
    }

    private void parseOrdering(Rules rules, String line) {
        orderingMatcher.reset(line);

        if (!orderingMatcher.matches()) {
            throw new RuntimeException("Failed to match ordering: " + line);
        }

        var before = Integer.parseInt(orderingMatcher.group(1));
        var after = Integer.parseInt(orderingMatcher.group(2));

        rules.addOrdering(before, after);
    }

    private void parseUpdate(Rules rules, String line) {
        updateMatcher.reset(line);

        var update = new ArrayList<Integer>();

        while (updateMatcher.find()) {
            update.add(Integer.parseInt(updateMatcher.group(1)));
        }

        rules.addUpdate(update);
    }
}
