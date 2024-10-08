package aoc.y2020.day19;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
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
