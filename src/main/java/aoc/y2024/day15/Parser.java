package aoc.y2024.day15;

import java.util.List;

public class Parser implements aoc.utils.Parser<State> {
    @Override
    public State parse(List<String> lines) {
        var state = new State();
        var inGrid = true;
        var row = 0;

        for (var line : lines) {
            if ("".equals(line.trim())) {
                inGrid = false;
                continue;
            }

            if (inGrid) {
                addToGrid(state, row, line);
                row++;
            } else {
                addToMoves(state, line);
            }
        }

        return state;
    }

    private void addToGrid(State state, int row, String line) {
        for (var col = 0; col < line.length(); col++) {
            var loc = new Cell(row, col);

            switch (line.charAt(col)) {
            case '#':
                state.walls.add(loc);
                break;
            case 'O':
                state.boxes.add(loc);
                break;
            case '@':
                state.robot = loc;
                break;
            default:
                break;
            }
        }
    }

    private void addToMoves(State state, String line) {
        for (var ch : line.toCharArray()) {
            state.moves.add(ch);
        }
    }
}
