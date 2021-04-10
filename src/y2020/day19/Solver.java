package y2020.day19;

import utils.Problem;

public abstract class Solver implements Problem {
    protected Notes input;

    protected Solver(Notes input) {
        this.input = input;
    }

    public long solve() {
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
