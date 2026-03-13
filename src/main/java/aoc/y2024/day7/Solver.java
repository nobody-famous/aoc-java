package aoc.y2024.day7;

import java.util.ArrayList;
import java.util.List;

import aoc.utils.LongProblem;

public abstract class Solver extends LongProblem {
    abstract boolean canBeTrue(Equation eq);

    @Override
    public long solve(List<String> lines) {
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
