package aoc.y2019.intcode;

import java.util.List;

public class Parser extends aoc.utils.Parser<long[]> {
    @Override
    public long[] parse(List<String> lines) {
        try {
            var line = lines.getFirst();
            var parts = line.split(",");
            var prog = new long[parts.length];

            for (var ndx = 0; ndx < parts.length; ndx += 1) {
                prog[ndx] = Long.parseLong(parts[ndx]);
            }

            return prog;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
