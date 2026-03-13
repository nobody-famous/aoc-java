package aoc.utils;

import java.util.List;

public class LongListParser implements aoc.utils.Parser<long[]> {
    @Override
    public long[] parse(List<String> lines) {
        return lines.stream().map(String::trim).mapToLong(Long::parseLong).toArray();
    }
}
