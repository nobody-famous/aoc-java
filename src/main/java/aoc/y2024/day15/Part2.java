package aoc.y2024.day15;

import java.util.stream.Collectors;

public class Part2 extends Solver {
    @Override
    protected void updateState(State state) {
        state.boxes = state.boxes
                .stream()
                .map(box -> new Cell(box.row, box.col * 2, 2))
                .collect(Collectors.toSet());
        state.walls = state.walls
                .stream()
                .map(box -> new Cell(box.row, box.col * 2, 2))
                .collect(Collectors.toSet());
        state.robot = new Cell(state.robot.row, state.robot.col * 2, 2);
    }
}
