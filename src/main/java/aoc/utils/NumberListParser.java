package aoc.utils;

import java.util.List;

public class NumberListParser implements Parser<int[]> {
    @Override
    public int[] parse(List<String> lines) {
        return lines.stream().map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}
