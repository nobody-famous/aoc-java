package aoc.y2020.day19;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract void updateInput(Notes input);

    @Override
    public Integer solve(List<String> lines) {
        var input = new Parser().parse(lines);
        var answer = 0;

        updateInput(input);

        for (var msg : input.messages()) {
            var m = new Matcher(input.rules(), msg);

            if (m.match()) {
                answer += 1;
            }
        }

        return answer;
    }
}
