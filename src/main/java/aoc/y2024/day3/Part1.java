package aoc.y2024.day3;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 extends Solver {
    private Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

    @Override
    protected Pattern getPattern() {
        return pattern;
    }

    @Override
    protected Optional<MultiplyNumbers> foundMatch(Matcher matcher) {
        return Optional.of(new MultiplyNumbers(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
    }
}
