package y2020.day13;

import utils.Problem;

public class Part1 implements Problem {
    private Notes input;

    public Part1(Notes input) {
        this.input = input;
    }

    public long solve() {
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
