package aoc.y2024.day15;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var state = new Parser().parse(lines);

        for (var move : state.moves) {
            tryMove(state, move);
        }

        return state.boxes
                .stream()
                .map(box -> box.row * 100 + box.col)
                .mapToInt(Integer::intValue)
                .sum();
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
        var cell = new Cell(state.robot.row + rowStep, state.robot.col + colStep);
        var lastCell = new Cell(state.robot.row + rowStep, state.robot.col + colStep);

        while (state.boxes.contains(lastCell)) {
            lastCell.row += rowStep;
            lastCell.col += colStep;
        }

        if (state.walls.contains(lastCell)) {
            return;
        }

        if (!cell.equals(lastCell)) {
            state.boxes.remove(cell);
            state.boxes.add(lastCell);
        }

        state.robot = cell;
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
