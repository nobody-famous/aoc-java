package aoc.y2024.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<Parser.InputItem>> {
    public record InputItem(int left, int right) {
    }

    private final Pattern pattern = Pattern.compile("(\\d+)\s+(\\d+)");
    private final Matcher matcher = pattern.matcher("");

    private InputItem parseLine(String line) {
        matcher.reset(line);

        if (!matcher.matches()) {
            throw new RuntimeException("Failed to match: " + line);
        }

        var left = Integer.parseInt(matcher.group(1));
        var right = Integer.parseInt(matcher.group(2));

        return new InputItem(left, right);
    }

    @Override
    public List<InputItem> parse(List<String> lines) {
        var items = new ArrayList<InputItem>();

        for (var line : lines) {
            items.add(parseLine(line));
        }

        return items;
    }
}
