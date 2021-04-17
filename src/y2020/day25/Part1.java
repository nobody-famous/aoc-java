package y2020.day25;

import utils.Problem;

public class Part1 extends Problem<Long> {
    private int[] input;

    public Part1(int[] input, long expected) {
        super(expected);
        this.input = input;
    }

    private long transform(long value, long subject) {
        value *= subject;
        value %= 20201227;

        return value;
    }

    public Long run() {
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
