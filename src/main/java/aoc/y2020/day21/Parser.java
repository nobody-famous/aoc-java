package aoc.y2020.day21;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<Food>> {
    private static Pattern foodPattern = Pattern.compile("(.*?) \\(contains (.*)\\)");
    private static Matcher foodMatcher = foodPattern.matcher("");

    @Override
    public List<Food> parse(List<String> lines) {
        return lines.stream().map(Parser::parseLine).toList();
    }

    private static Food parseLine(String line) {
        foodMatcher.reset(line);

        if (!foodMatcher.matches()) {
            throw new RuntimeException("Invalid input: " + line);
        }

        var ingredients = foodMatcher.group(1).trim().split(" ");
        var allergens = Arrays.stream(foodMatcher.group(2).trim().split(",")).map(String::trim).toArray(String[]::new);

        return new Food(ingredients, allergens);
    }
}
