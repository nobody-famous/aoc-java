package aoc.y2020.day13;

import java.util.List;

public class Parser implements aoc.utils.Parser<Notes> {
    @Override
    public Notes parse(List<String> lines) {
        var timestamp = Long.parseLong(lines.get(0));
        var parts = lines.get(1).split(",");
        var ids = new Integer[parts.length];

        for (var index = 0; index < parts.length; index++) {
            ids[index] = "x".equals(parts[index]) ? null : Integer.parseInt(parts[index]);
        }

        return new Notes(timestamp, ids);
    }
}
