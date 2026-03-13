package aoc.y2020.day6;

import java.util.ArrayList;
import java.util.List;

public class Parser implements aoc.utils.Parser<List<List<String>>> {
    @Override
    public List<List<String>> parse(List<String> lines) {
        var groups = new ArrayList<List<String>>();
        var group = new ArrayList<String>();

        for (var line : lines) {
            if (line.trim().length() == 0) {
                groups.add(group);
                group = new ArrayList<String>();
                continue;
            }

            group.add(line);
        }

        if (!group.isEmpty()) {
            groups.add(group);
        }

        return groups;
    }
}
