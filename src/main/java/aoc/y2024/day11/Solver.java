package aoc.y2024.day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import aoc.utils.AocProblem;

public class Solver implements AocProblem<Long> {
    private static final int MULTIPLIER = 2024;

    private record CacheKey(long stone, int depth) {
    }

    private Map<CacheKey, Long> cache = new HashMap<>();
    private int targetDepth;

    protected Solver(int targetDepth) {
        this.targetDepth = targetDepth;
    }

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

    private long countStones(int depth, long stone) {
        if (depth == targetDepth) {
            return 1;
        }

        var newStones = playStone(stone);
        var total = 0L;

        for (var newStone : newStones) {
            var key = new CacheKey(newStone, depth);
            if (cache.containsKey(key)) {
                total += cache.get(key);
                continue;
            }

            var count = countStones(depth + 1, newStone);
            total += count;
            cache.put(key, count);
        }

        return total;
    }

    @Override
    public Long solve(List<String> lines) {
        var input = Arrays.stream(lines.get(0).split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        var answer = 0L;

        for (var stone : input) {
            answer += countStones(0, stone);
        }

        return answer;
    }
}
