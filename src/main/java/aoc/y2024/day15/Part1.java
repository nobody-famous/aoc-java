package aoc.y2024.day15;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var state = new Parser().parse(lines);

        printGrid(state);
        for (var move : state.moves) {
            tryMove(state, move);
        }
        printGrid(state);

        return 0;
    }

    private void tryMove(State state, char move) {
        switch (move) {
        case '<':
            tryMove(state, 0, -1);
            break;
        case '>':
            tryMove(state, 0, 1);
            break;
        case '^':
            tryMove(state, -1, 0);
            break;
        case 'v':
            tryMove(state, 1, 0);
            break;
        default:
            throw new RuntimeException("Invalid move: " + move);
        }
    }

    private void tryMove(State state, int rowStep, int colStep) {
        var target = new Cell(state.robot.row + rowStep, state.robot.col + colStep);

        if (!state.boxes.contains(target) && !state.walls.contains(target)) {
            state.robot = target;
        }
    }

    private void printGrid(State state) {
        var min = state.walls.stream().min(Part1::compareCells).orElseThrow();
        var max = state.walls.stream().max(Part1::compareCells).orElseThrow();

        for (var row = min.row; row <= max.row; row++) {
            for (var col = min.col; col <= max.col; col++) {
                var cell = new Cell(row, col);

                if (state.walls.contains(cell)) {
                    System.out.print('#');
                } else if (state.boxes.contains(cell)) {
                    System.out.print('O');
                } else if (cell.equals(state.robot)) {
                    System.out.print('@');
                } else {
                    System.out.print('.');
                }
            }

            System.out.println();
        }
    }

    private static int compareCells(Cell a, Cell b) {
        if (a.row > b.row) {
            return 1;
        } else if (a.row < b.row) {
            return -1;
        } else if (a.col > b.col) {
            return 1;
        } else {
            return -1;
        }
    }
}
