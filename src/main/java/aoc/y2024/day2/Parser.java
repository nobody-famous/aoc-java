package aoc.y2024.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<List<Integer>>> {
    private final Pattern pattern = Pattern.compile("\\d+");
    private final Matcher matcher = pattern.matcher("");

    private List<Integer> parseLine(String line) {
        matcher.reset(line);

        var items = new ArrayList<Integer>();

        while (matcher.find()) {
            items.add(Integer.parseInt(matcher.group()));
        }

        return items;
    }

    @Override
    public List<List<Integer>> parse(List<String> lines) {
        var items = new ArrayList<List<Integer>>();

        for (var line : lines) {
            items.add(parseLine(line));
        }

        return items;
    }
}
