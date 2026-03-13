package aoc.y2024.day3;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 extends Solver {
    private Pattern pattern = Pattern.compile("don't\\(\\)|do\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)");
    private boolean doMultiply = true;

    @Override
    protected Pattern getPattern() {
        return pattern;
    }

    @Override
    protected Optional<MultiplyNumbers> foundMatch(Matcher matcher) {
        if (matcher.group().startsWith("mul(")) {
            return doMultiply
                    ? Optional.of(new MultiplyNumbers(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))))
                    : Optional.empty();
        }

        if ("do()".equals(matcher.group())) {
            doMultiply = true;
        } else if ("don't()".equals(matcher.group())) {
            doMultiply = false;
        }

        return Optional.empty();
    }
}
