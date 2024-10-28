package aoc.y2020.day13;

import aoc.y2020.Y2020Problem;

public class Part1 extends Y2020Problem<Long> {
    private final Notes input;

    public Part1(Notes input, long expected) {
        super(expected);
        this.input = input;
    }

    public Long run() {
        var min = Long.MAX_VALUE;
        var busID = 0;

        for (var id : input.ids()) {
            if (id == null) {
                continue;
            }

            var diff = id - (input.timestamp() % id);

            if (diff < min) {
                min = diff;
                busID = id;
            }
        }

        return busID * min;
    }
}
