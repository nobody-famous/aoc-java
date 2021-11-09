package aoc.y2020.day19;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Long> {
    protected Notes input;

    protected Solver(Notes input, long expected) {
        super(expected);
        this.input = input;
    }

    public Long run() {
        var answer = 0L;

        for (var msg : input.getMsgs()) {
            var m = new Matcher(input.getRules(), msg);

            if (m.match()) {
                answer += 1;
            }
        }

        return answer;
    }
}
