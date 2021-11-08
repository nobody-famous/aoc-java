package aoc.y2020.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 extends Solver {
    public Part2(int[] input, long expected) {
        super(input, expected);
    }

    private List<Integer> getSteps(int[] input, int start) {
        var steps = new ArrayList<Integer>();
        var value = input[start];

        for (var ndx = start + 1; ndx < input.length; ndx += 1) {
            if (input[ndx] > value + 3) {
                break;
            }

            steps.add(input[ndx]);
        }

        return steps;
    }

    private Map<Integer, List<Integer>> buildStepsMap(int[] input) {
        var steps = new HashMap<Integer, List<Integer>>();

        for (var ndx = 0; ndx < input.length; ndx += 1) {
            steps.put(input[ndx], getSteps(input, ndx));
        }

        return steps;
    }

    private Map<Integer, Long> buildArrangeMap(int[] input, Map<Integer, List<Integer>> stepsMap) {
        var arranges = new HashMap<Integer, Long>();

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

    public Long run() {
        var adapters = addAdapters(input);
        Arrays.sort(adapters);

        var stepsMap = buildStepsMap(adapters);
        var arranges = buildArrangeMap(adapters, stepsMap);

        var answer = arranges.get(0);

        return answer;
    }
}
