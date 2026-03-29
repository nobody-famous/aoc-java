package aoc.y2024.day15;

import aoc.utils.Grid;

public class Part1 extends Solver {
    @Override
    protected void updateState(State state) {
        state.robot = findRobot(state.grid);
    }

    @Override
    public void tryMove(State state, char move) {
        var rowStep = switch (move) {
        case 'v' -> 1;
        case '^' -> -1;
        default -> 0;
        };
        var colStep = switch (move) {
        case '>' -> 1;
        case '<' -> -1;
        default -> 0;
        };

        var loc = new Grid.Loc(state.robot.row() + rowStep, state.robot.col() + colStep);
        var lastLoc = loc;

        while (state.grid[lastLoc.row()][lastLoc.col()] == 'O') {
            lastLoc = new Grid.Loc(lastLoc.row() + rowStep, lastLoc.col() + colStep);
        }

        if (state.grid[lastLoc.row()][lastLoc.col()] == '#') {
            return;
        }

        state.grid[lastLoc.row()][lastLoc.col()] = 'O';
        state.grid[loc.row()][loc.col()] = '@';
        state.grid[state.robot.row()][state.robot.col()] = '.';

        state.robot = loc;
    }
}
