package aoc.y2024.day7;

import java.util.List;

public class Part1 extends Solver {
    private boolean canBeTrue(long target, List<Long> numbers, int index) {
        return index < 0
                ? target == 0
                : (target % numbers.get(index) == 0 && canBeTrue(target / numbers.get(index), numbers, index - 1))
                        || (target - numbers.get(index) >= 0 && canBeTrue(target - numbers.get(index), numbers, index - 1));
    }

    @Override
    protected boolean canBeTrue(Equation eq) {
        return canBeTrue(eq.value(), eq.numbers(), eq.numbers().size() - 1);
    }
}
