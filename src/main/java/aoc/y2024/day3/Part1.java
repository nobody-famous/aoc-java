package aoc.y2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.Problem;

public class Part1 extends Problem<Integer> {
    private record MultiplyNumbers(int x, int y) {
    }

    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    public Integer run(List<String> lines) {
        var numbers = new ArrayList<MultiplyNumbers>();

        for (var line : lines) {
            numbers.addAll(parse(line));
        }

        return calculateAnswer(numbers);
    }

    private Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    private Matcher matcher = pattern.matcher("");

    private List<MultiplyNumbers> parse(String line) {
        var numbers = new ArrayList<MultiplyNumbers>();

        matcher.reset(line);
        while (matcher.find()) {
            numbers.add(new MultiplyNumbers(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }

        return numbers;
    }

    private int calculateAnswer(List<MultiplyNumbers> numbers) {
        var answer = 0;

        for (var item : numbers) {
            answer += item.x * item.y;
        }

        return answer;
    }
}
