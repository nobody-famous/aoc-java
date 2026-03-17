package aoc.y2024.day11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    private static final int MULTIPLIER = 2024;

    private int countDigits(long number) {
        return (int) Math.log10(number) + 1;
    }

    private List<Long> splitStone(int digits, long number) {
        var base = (long) Math.pow(10, digits);

        return List.of(number / base, number % base);
    }

    private List<Long> playStone(long number) {
        var numDigits = countDigits(number);

        if (number == 0) {
            return List.of(1L);
        } else if ((numDigits % 2) == 0) {
            return splitStone(numDigits / 2, number);
        } else {
            return List.of(number * MULTIPLIER);
        }
    }

    private List<Long> playStone(long number, int count) {
        var list = List.of(number);

        for (var iter = 0; iter < count; iter++) {
            list = list.stream().flatMap(stone -> playStone(stone).stream()).toList();
        }

        return list;
    }

    @Override
    public Integer solve(List<String> lines) {
        var input = Arrays.stream(lines.get(0).split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        return input.stream().flatMap(stone -> playStone(stone, 25).stream()).toList().size();
    }
}
