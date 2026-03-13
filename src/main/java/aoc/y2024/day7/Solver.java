package aoc.y2024.day7;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    abstract boolean canBeTrue(Equation eq);

    @Override
    public Long solve(List<String> lines) {
        var equations = new Parser().parse(lines);
        var valid = new ArrayList<Equation>();

        for (var equation : equations) {
            if (canBeTrue(equation)) {
                valid.add(equation);
            }
        }

        return getAnswer(valid);
    }

    private long getAnswer(List<Equation> equations) {
        var answer = 0L;

        for (var eq : equations) {
            answer += eq.value();
        }

        return answer;
    }
}
