package y2020.day18;

import utils.Problem;

public class Part1 implements Problem {
    private String[] input;

    public Part1(String[] input) {
        this.input = input;
    }

    public long solve() {
        var answer = 0L;

        for (var exprStr : input) {
            var expr = new Expression(exprStr);

            answer += expr.eval();
        }

        return answer;
    }
}
