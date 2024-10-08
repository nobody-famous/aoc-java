package aoc.y2020.day18;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    private String[] input;
    private boolean usePrecedence;

    public Solver(String[] input, boolean usePrecedence, long expected) {
        super(expected);
        this.input = input;
        this.usePrecedence = usePrecedence;
    }

    public Long run() {
        var answer = 0L;

        for (var exprStr : input) {
            var expr = new Expression(exprStr, usePrecedence);
            var value = expr.eval();

            answer += value;
        }

        return answer;
    }
}
