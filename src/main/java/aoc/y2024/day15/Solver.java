package aoc.y2024.day15;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.utils.Grid;

public abstract class Solver implements AocProblem<Integer> {
    protected abstract void updateState(State state);

    protected abstract void tryMove(State state, char move);

    @Override
    public Integer solve(List<String> lines) {
        var state = new Parser().parse(lines);

        updateState(state);
        printGrid(state);
        tryMove(state, '<');
        printGrid(state);

        // for (var move : state.moves) {
        //     tryMove(state, move);
        // }

        return sumGPS(state.grid);
    }

    private int sumGPS(char[][] grid) {
        var sum = 0;

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 'O' || grid[row][col] == '[') {
                    sum += row * 100 + col;
                }
            }
        }

        return sum;
    }

    protected Grid.Loc findRobot(char[][] grid) {
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '@') {
                    return new Grid.Loc(row, col);
                }
            }
        }

        throw new RuntimeException("Could not find robot");
    }

    protected void printGrid(State state) {
        for (var row = 0; row < state.grid.length; row++) {
            for (var col = 0; col < state.grid[row].length; col++) {
                System.out.print(state.grid[row][col]);
            }

            System.out.println();
        }
    }
}
