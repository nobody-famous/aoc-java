package aoc.y2024.day7;

import java.util.List;

public class Part2 extends Solver {
    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    private boolean endsWith(long number, long suffix) {
        return Long.toString(number).endsWith(Long.toString(suffix));
    }

    private Long removeSuffix(long number, long suffix) {
        var numberString = Long.toString(number);
        var suffixString = Long.toString(suffix);

        return Long.parseLong(numberString.substring(0, numberString.length() - suffixString.length()));
    }

    private boolean canBeTrue(long target, List<Long> numbers, int index) {
        return index < 0
                ? target == 0
                : (target % numbers.get(index) == 0 && canBeTrue(target / numbers.get(index), numbers, index - 1))
                        || (target - numbers.get(index) >= 0 && canBeTrue(target - numbers.get(index), numbers, index - 1))
                        || (endsWith(target, numbers.get(index)) && canBeTrue(removeSuffix(target, numbers.get(index)), numbers, index - 1));
    }

    @Override
    protected boolean canBeTrue(Equation eq) {
        return canBeTrue(eq.value(), eq.numbers(), eq.numbers().size() - 1);
    }
}
