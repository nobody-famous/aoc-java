package aoc.y2019.day16;

import java.util.List;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public int doWork(List<Integer> numbers) {
        for (var loop = 0; loop < 100; loop += 1) {
            numbers = applyPattern(numbers);
        }

        return listToInt(numbers.subList(0, 8));
    }
}
