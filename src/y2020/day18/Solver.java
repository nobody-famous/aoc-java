package y2020.day18;

import utils.Problem;

public abstract class Solver implements Problem {
    private String[] input;
    private boolean usePrecedence;

    public Solver(String[] input, boolean usePrecedence) {
        this.input = input;
        this.usePrecedence = usePrecedence;
    }

    public long solve() {
        var answer = 0L;

        for (var exprStr : input) {
            var expr = new Expression(exprStr, usePrecedence);
            var value = expr.eval();

            answer += value;
        }

        return answer;
    }
}
