package aoc.y2024.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Utils {
    public static String getOutput(long aValue, List<Integer> program) {
        var output = new ArrayList<Long>();
        var computer = new Computer((value) -> output.add(value));

        computer.init(aValue, 0, 0);
        computer.run(program);

        return output.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
