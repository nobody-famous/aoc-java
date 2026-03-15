package aoc.y2020.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser implements aoc.utils.Parser<Notes> {
    private enum Stages {
        FIELDS, YOURS, NEARBY
    };

    private static final Pattern fieldPattern = Pattern.compile("(.*): (\\d+)-(\\d+) or (\\d+)-(\\d+)");
    private static final Matcher fieldMatcher = fieldPattern.matcher("");

    @Override
    public Notes parse(List<String> lines) {
        var stage = Stages.FIELDS;
        var fields = new ArrayList<Field>();
        var nearby = new ArrayList<Ticket>();
        Ticket yours = null;

        for (var line : lines) {
            if ("".equals(line.trim())) {
                continue;
            } else if (line.startsWith("your")) {
                stage = Stages.YOURS;
                continue;
            } else if (line.startsWith("nearby")) {
                stage = Stages.NEARBY;
                continue;
            }

            if (stage == Stages.FIELDS) {
                fields.add(parseField(line));
            } else if (stage == Stages.YOURS) {
                yours = parseTicket(line);
            } else if (stage == Stages.NEARBY) {
                nearby.add(parseTicket(line));
            }
        }

        return new Notes(fields, yours, nearby);
    }

    private static Field parseField(String line) {
        fieldMatcher.reset(line);

        if (!fieldMatcher.matches()) {
            throw new RuntimeException("Invalid input: " + line);
        }

        return new Field(fieldMatcher.group(1), List.of(
                new Range(Long.parseLong(fieldMatcher.group(2)), Long.parseLong(fieldMatcher.group(3))),
                new Range(Long.parseLong(fieldMatcher.group(4)), Long.parseLong(fieldMatcher.group(5)))));
    }

    private static Ticket parseTicket(String line) {
        return new Ticket(Arrays.stream(line.split(",")).map(String::trim).mapToLong(Long::parseLong).boxed().collect(Collectors.toList()));
    }
}
