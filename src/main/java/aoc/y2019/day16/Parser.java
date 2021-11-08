package aoc.y2019.day16;

import java.util.ArrayList;
import java.util.List;

public class Parser extends aoc.utils.Parser<List<Integer>> {
    public Parser(String fileName) {
        super(fileName);
    }

    private List<Integer> toIntList(String line) {
        var list = new ArrayList<Integer>();

        for (var ch : line.toCharArray()) {
            list.add(ch - '0');
        }

        return list;
    }

    public List<Integer> parse() {
        try {
            var lines = readLines();

            return toIntList(lines.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
