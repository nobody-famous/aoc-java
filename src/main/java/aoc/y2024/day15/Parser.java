package aoc.y2024.day15;

import java.util.ArrayList;
import java.util.List;

public class Parser implements aoc.utils.Parser<State> {
    @Override
    public State parse(List<String> lines) {
        var state = new State();
        var inGrid = true;
        var rows = new ArrayList<char[]>();

        for (var line : lines) {
            if ("".equals(line.trim())) {
                inGrid = false;
                continue;
            }

            if (inGrid) {
                addToGrid(state, rows, line);
            } else {
                addToMoves(state, line);
            }
        }

        state.grid = new char[rows.size()][];

        for (var row = 0; row < rows.size(); row++) {
            state.grid[row] = rows.get(row);
        }

        return state;
    }

    private void addToGrid(State state, List<char[]> rows, String line) {
        rows.add(line.toCharArray());
    }

    private void addToMoves(State state, String line) {
        for (var ch : line.toCharArray()) {
            state.moves.add(ch);
        }
    }
}
