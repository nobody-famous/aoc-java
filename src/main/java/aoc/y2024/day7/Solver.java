package aoc.y2024.day7;

import java.util.ArrayList;
import java.util.List;

public abstract class Solver extends aoc.utils.Problem<Long> {
    abstract boolean canBeTrue(Equation eq);

    public Solver(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
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
