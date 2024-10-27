package aoc.y2019.day16;

import java.util.ArrayList;
import java.util.List;

public class Parser extends aoc.utils.Parser<List<Integer>> {
    private List<Integer> toIntList(String line) {
        var list = new ArrayList<Integer>();

        for (var ch : line.toCharArray()) {
            list.add(ch - '0');
        }

        return list;
    }

    @Override
    public List<Integer> parse(List<String> lines) {
        try {
            return toIntList(lines.getFirst());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
