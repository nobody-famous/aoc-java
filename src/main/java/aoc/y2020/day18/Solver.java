package aoc.y2020.day18;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    protected abstract boolean usePrecedence();

    @Override
    public Long solve(List<String> lines) {
        var answer = 0L;

        for (var exprStr : lines) {
            var expr = new Expression(exprStr, usePrecedence());
            var value = expr.eval();

            answer += value;
        }

        return answer;
    }
}
