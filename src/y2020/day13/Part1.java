package y2020.day13;

import utils.Problem;

public class Part1 extends Problem<Long> {
    private Notes input;

    public Part1(Notes input, long expected) {
        super(expected);
        this.input = input;
    }

    public Long run() {
        var min = Long.MAX_VALUE;
        var busID = 0;

        for (var id : input.getIds()) {
            if (id == null) {
                continue;
            }

            var diff = id - (input.getTimestamp() % id);

            if (diff < min) {
                min = diff;
                busID = id;
            }
        }

        var answer = busID * min;

        return answer;
    }
}
