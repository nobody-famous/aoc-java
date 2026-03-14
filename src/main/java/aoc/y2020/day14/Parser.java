package aoc.y2020.day14;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<Op>> {
    private static final Pattern maskPattern = Pattern.compile("mask = ([X01]{36})");
    private static final Matcher maskMatcher = maskPattern.matcher("");
    private static final Pattern memPattern = Pattern.compile("mem\\[(\\d+)\\] = (\\d+)");
    private static final Matcher memMatcher = memPattern.matcher("");

    @Override
    public List<Op> parse(List<String> lines) {
        return lines.stream().map(Parser::parseLine).toList();
    }

    private static Op parseLine(String line) {
        maskMatcher.reset(line);
        memMatcher.reset(line);

        if (maskMatcher.matches()) {
            return new Mask(maskMatcher.group(1));
        } else if (memMatcher.matches()) {
            return new Memory(Long.parseLong(memMatcher.group(1)), Long.parseLong(memMatcher.group(2)));
        }

        throw new RuntimeException("Invalid input: " + line);
    }
}
