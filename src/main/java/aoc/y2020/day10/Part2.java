package aoc.y2020.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.LongListParser;

public class Part2 extends Solver {
    private List<Long> getSteps(long[] input, int start) {
        var steps = new ArrayList<Long>();
        var value = input[start];

        for (var ndx = start + 1; ndx < input.length; ndx += 1) {
            if (input[ndx] > value + 3) {
                break;
            }

            steps.add(input[ndx]);
        }

        return steps;
    }

    private Map<Long, List<Long>> buildStepsMap(long[] input) {
        var steps = new HashMap<Long, List<Long>>();

        for (var ndx = 0; ndx < input.length; ndx += 1) {
            steps.put(input[ndx], getSteps(input, ndx));
        }

        return steps;
    }

    private Map<Long, Long> buildArrangeMap(long[] input, Map<Long, List<Long>> stepsMap) {
        var arranges = new HashMap<Long, Long>();

        arranges.put(input[input.length - 1], 1L);

        for (var ndx = input.length - 2; ndx >= 0; ndx -= 1) {
            var entry = input[ndx];
            var steps = stepsMap.get(entry);
            var sum = 0L;

            for (var step : steps) {
                sum += arranges.get(step);
            }

            arranges.put(entry, sum);
        }

        return arranges;
    }

    @Override
    public Long solve(List<String> lines) {
        var input = new LongListParser().parse(lines);
        var adapters = addAdapters(input);
        Arrays.sort(adapters);

        var stepsMap = buildStepsMap(adapters);
        var arranges = buildArrangeMap(adapters, stepsMap);

        return arranges.get(0L);
    }
}
