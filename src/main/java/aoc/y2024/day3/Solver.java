package aoc.y2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.Problem;

public abstract class Solver extends Problem<Integer> {
    protected record MultiplyNumbers(int x, int y) {
    }

    protected abstract Pattern getPattern();

    protected abstract void foundMatch(Matcher matcher, List<MultiplyNumbers> numbers);

    public Solver(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var numbers = new ArrayList<MultiplyNumbers>();
        var matcher = getPattern().matcher("");

        for (var line : lines) {
            matcher.reset(line);

            while (matcher.find()) {
                foundMatch(matcher, numbers);
            }
        }

        return calculateAnswer(numbers);
    }

    private int calculateAnswer(List<MultiplyNumbers> numbers) {
        var answer = 0;

        for (var item : numbers) {
            answer += item.x() * item.y();
        }

        return answer;
    }
}
