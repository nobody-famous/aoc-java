package aoc.y2024.day13;

import java.util.List;
import java.util.Optional;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Long> {
    protected abstract List<MachineData> updateData(List<MachineData> data);

    @Override
    public Long solve(List<String> lines) {
        var data = updateData(new Parser().parse(lines));

        return data.stream()
                .map(machine -> calculatePressesB(machine)
                        .flatMap(bPresses -> calculatePressesA(bPresses, machine)
                                .map(aPresses -> aPresses * 3 + bPresses)))
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .mapToLong(Long::longValue)
                .sum();
    }

    private Optional<Long> calculatePressesB(MachineData data) {
        var num = data.prize().x() * data.buttonA().y() - data.buttonA().x() * data.prize().y();
        var den = (data.buttonA().y() * data.buttonB().x() - data.buttonA().x() * data.buttonB().y());

        return num % den == 0 ? Optional.of(num / den) : Optional.empty();
    }

    private Optional<Long> calculatePressesA(long bPresses, MachineData data) {
        var num = data.prize().y() - data.buttonB().y() * bPresses;
        var den = data.buttonA().y();

        return num % den == 0 ? Optional.of(num / den) : Optional.empty();
    }
}
