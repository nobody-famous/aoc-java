package aoc.y2024.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 extends aoc.utils.Problem<Long> {
    private final Pattern numbersPattern = Pattern.compile("(\\d+)");
    private final Pattern eqPattern = Pattern.compile("(\\d+):(.*)");
    private final Matcher numbersMatcher = numbersPattern.matcher("");
    private final Matcher eqMatcher = eqPattern.matcher("");

    public Part1(String fileName, long exp) {
        super(fileName, exp);
    }

    private record Equation(long value, List<Long> numbers) {
    }

    private List<Long> parseNumbers(String input) {
        var numbers = new ArrayList<Long>();

        numbersMatcher.reset(input);

        while (numbersMatcher.find()) {
            numbers.add(Long.parseLong(numbersMatcher.group(1)));
        }

        return numbers;
    }

    private Equation parseLine(String line) {
        eqMatcher.reset(line);

        if (!eqMatcher.matches()) {
            throw new RuntimeException("Failed to match: " + line);
        }

        var value = Long.parseLong(eqMatcher.group(1));
        var numbers = parseNumbers(eqMatcher.group(2));

        return new Equation(value, numbers);
    }

    private List<Equation> parse(List<String> lines) {
        var equations = new ArrayList<Equation>();

        for (var line : lines) {
            equations.add(parseLine(line));
        }

        return equations;
    }

    private boolean canBeTrue(long target, List<Long> numbers, int index) {
        return index < 0
                ? target == 0
                : (target % numbers.get(index) == 0 && canBeTrue(target / numbers.get(index), numbers, index - 1))
                        || (target - numbers.get(index) >= 0 && canBeTrue(target - numbers.get(index), numbers, index - 1));
    }

    private boolean canBeTrue(Equation eq) {
        return canBeTrue(eq.value, eq.numbers, eq.numbers.size() - 1);
    }

    private long getAnswer(List<Equation> equations) {
        var answer = 0L;

        for (var eq : equations) {
            answer += eq.value;
        }

        return answer;
    }

    @Override
    public Long run(List<String> lines) {
        var equations = parse(lines);
        var valid = new ArrayList<Equation>();

        for (var equation : equations) {
            if (canBeTrue(equation)) {
                valid.add(equation);
            }
        }

        return getAnswer(valid);
    }
}
