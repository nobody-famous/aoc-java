package aoc.y2020.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser implements aoc.utils.Parser<List<DBEntry>> {
    @Override
    public List<DBEntry> parse(List<String> lines) {
        var regex = Pattern.compile("(\\d+)-(\\d+) +(.): *(.*)");
        var matcher = regex.matcher("");
        var entries = new ArrayList<DBEntry>();

        for (var line : lines) {
            matcher.reset(line);

            if (!matcher.matches()) {
                throw new RuntimeException("Invalid input: " + line);
            }

            var low = Integer.parseInt(matcher.group(1));
            var high = Integer.parseInt(matcher.group(2));
            var ch = matcher.group(3).charAt(0);
            var password = matcher.group(4);

            entries.add(new DBEntry(new Policy(low, high, ch), password));
        }

        return entries;
    }
}
