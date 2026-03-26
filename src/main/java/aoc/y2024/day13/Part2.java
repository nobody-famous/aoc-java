package aoc.y2024.day13;

import java.util.List;

public class Part2 extends Solver {
    private final static long MODIFIER = 10000000000000L;

    @Override
    protected List<MachineData> updateData(List<MachineData> data) {
        return data
                .stream()
                .map(m -> new MachineData(m.buttonA(), m.buttonB(), new Movement(m.prize().x() + MODIFIER, m.prize().y() + MODIFIER)))
                .toList();
    }
}
