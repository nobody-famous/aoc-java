package aoc.y2024.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Pattern numbersPattern = Pattern.compile("(\\d+)");
    private final Pattern eqPattern = Pattern.compile("(\\d+):(.*)");
    private final Matcher numbersMatcher = numbersPattern.matcher("");
    private final Matcher eqMatcher = eqPattern.matcher("");

    public List<Equation> parse(String lines) {
        var equations = new ArrayList<Equation>();

        return equations;
    }

    public List<Equation> parse(List<String> lines) {
        var equations = new ArrayList<Equation>();

        for (var line : lines) {
            equations.add(parseLine(line));
        }

        return equations;
    }

    private Equation parseLine(String line) {
        eqMatcher.reset(line);

        if (!eqMatcher.matches()) {
            throw new RuntimeException("Failed to match: " + line);
        }

        var value = Long.parseLong(eqMatcher.group(1));
        var numbers = parseNumbers(eqMatcher.group(2));

        return new Equation(value, numbers);
    }

    private List<Long> parseNumbers(String input) {
        var numbers = new ArrayList<Long>();

        numbersMatcher.reset(input);

        while (numbersMatcher.find()) {
            numbers.add(Long.parseLong(numbersMatcher.group(1)));
        }

        return numbers;
    }
}
