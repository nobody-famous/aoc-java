package aoc.y2024.day13;

import java.util.List;
import java.util.Optional;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var data = new Parser().parse(lines);

        return data.stream()
                .map(machine -> calculatePressesB(machine)
                        .flatMap(bPresses -> calculatePressesA(bPresses, machine)
                                .map(aPresses -> aPresses * 3 + bPresses)))
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Optional<Integer> calculatePressesB(MachineData data) {
        int num = data.prize().x * data.buttonA().y - data.buttonA().x * data.prize().y;
        int den = (data.buttonA().y * data.buttonB().x - data.buttonA().x * data.buttonB().y);

        return num % den == 0 ? Optional.of(num / den) : Optional.empty();
    }

    private Optional<Integer> calculatePressesA(int bPresses, MachineData data) {
        int num = data.prize().y - data.buttonB().y * bPresses;
        int den = data.buttonA().y;

        return num % den == 0 ? Optional.of(num / den) : Optional.empty();
    }
}
