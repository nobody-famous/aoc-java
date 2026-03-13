package aoc.y2020.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<BagRule>> {
    private static final Pattern contentPattern = Pattern.compile("(\\d+) +(.*?) bag[s]?[,.]");
    private static final Matcher contentMatcher = contentPattern.matcher("");

    @Override
    public List<BagRule> parse(List<String> lines) {
        return lines.stream().map(Parser::parseLine).toList();
    }

    private static BagRule parseLine(String line) {
        var parts = line.split("bags contain");
        var type = parts[0].trim();
        var content = parseContent(parts[1]);

        return new BagRule(type, content);
    }

    private static List<BagContents> parseContent(String content) {
        var contents = new ArrayList<BagContents>();

        contentMatcher.reset(content);

        while (contentMatcher.find()) {
            var count = Integer.parseInt(contentMatcher.group(1));
            var type = contentMatcher.group(2);

            contents.add(new BagContents(count, type));
        }

        return contents;
    }
}
