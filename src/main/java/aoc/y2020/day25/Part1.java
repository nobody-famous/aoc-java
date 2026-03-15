package aoc.y2020.day25;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.LongListParser;

public class Part1 implements AocProblem<Long> {
    private long transform(long value, long subject) {
        value *= subject;
        value %= 20201227;

        return value;
    }

    @Override
    public Long solve(List<String> lines) {
        var input = new LongListParser().parse(lines);
        var value = 1L;
        var subject = 7L;
        var loopSize = 0;

        while (value != input[0]) {
            value = transform(value, subject);
            loopSize += 1;
        }

        value = 1L;
        for (var loop = 0; loop < loopSize; loop += 1) {
            value = transform(value, input[1]);
        }

        return value;
    }
}
