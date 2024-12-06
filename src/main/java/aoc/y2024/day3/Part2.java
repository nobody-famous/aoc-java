package aoc.y2024.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 extends Solver {
    private Pattern pattern = Pattern.compile("don't\\(\\)|do\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)");
    private boolean doMultiply = true;

    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected Pattern getPattern() {
        return pattern;
    }

    @Override
    protected void foundMatch(Matcher matcher, List<MultiplyNumbers> numbers) {
        if ("do()".equals(matcher.group())) {
            doMultiply = true;
        } else if ("don't()".equals(matcher.group())) {
            doMultiply = false;
        } else if (doMultiply) {
            numbers.add(new MultiplyNumbers(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }
    }
}
