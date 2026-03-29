package aoc.y2024.day15;

import java.util.HashSet;
import java.util.Set;

import aoc.utils.Grid;

public class Part2 extends Solver {
    @Override
    protected void updateState(State state) {
        var newGrid = new char[state.grid.length][];

        for (var row = 0; row < state.grid.length; row++) {
            newGrid[row] = new char[state.grid[row].length * 2];

            for (var col = 0; col < state.grid[row].length; col++) {
                var value = state.grid[row][col];

                if (value == '#') {
                    newGrid[row][col * 2] = '#';
                    newGrid[row][(col * 2) + 1] = '#';
                } else if (value == 'O') {
                    newGrid[row][col * 2] = '[';
                    newGrid[row][(col * 2) + 1] = ']';
                } else if (value == '@') {
                    newGrid[row][col * 2] = '@';
                    newGrid[row][(col * 2) + 1] = '.';
                } else {
                    newGrid[row][col * 2] = '.';
                    newGrid[row][(col * 2) + 1] = '.';
                }
            }
        }

        state.grid = newGrid;
        state.robot = findRobot(state.grid);
    }

    @Override
    protected void tryMove(State state, char move) {
        if (move == '<') {
            moveLeft(state);
        } else if (move == '>') {
            moveRight(state);
        } else if (move == '^') {
            moveUp(state);
        } else if (move == 'v') {
            moveDown(state);
        }
    }

    private void moveLeft(State state) {
        moveHorizontal(state, -1, ']');
    }

    private void moveRight(State state) {
        moveHorizontal(state, 1, '[');
    }

    private void moveHorizontal(State state, int colStep, char box) {
        var cell = new Grid.Loc(state.robot.row(), state.robot.col() + colStep);
        var lastCell = cell;

        while (state.grid[lastCell.row()][lastCell.col()] == box) {
            lastCell = new Grid.Loc(lastCell.row(), lastCell.col() + (colStep * 2));
        }

        if (state.grid[lastCell.row()][lastCell.col()] == '#') {
            return;
        }

        for (var col = lastCell.col(); col != cell.col(); col -= colStep) {
            state.grid[state.robot.row()][col] = state.grid[state.robot.row()][col - colStep];
        }

        state.grid[state.robot.row()][state.robot.col()] = '.';
        state.grid[state.robot.row()][cell.col()] = '@';
        state.robot = cell;
    }

    private void moveUp(State state) {
        moveVertical(state, -1);
    }

    private void moveDown(State state) {
        moveVertical(state, 1);
    }

    private void moveVertical(State state, int rowStep) {
        var cell = new Grid.Loc(state.robot.row() + rowStep, state.robot.col());
        var frontier = Set.of(cell);
        var toMove = new HashSet<Grid.Loc>();

        while (!frontier.isEmpty()) {
            var newFrontier = new HashSet<Grid.Loc>();

            for (var loc : frontier) {
                var value = state.grid[loc.row()][loc.col()];

                if (value == '#') {
                    return;
                }

                if (value == '[') {
                    toMove.add(loc);
                    toMove.add(new Grid.Loc(loc.row(), loc.col() + 1));
                    newFrontier.add(new Grid.Loc(loc.row() + rowStep, loc.col()));
                    newFrontier.add(new Grid.Loc(loc.row() + rowStep, loc.col() + 1));
                } else if (value == ']') {
                    toMove.add(loc);
                    toMove.add(new Grid.Loc(loc.row(), loc.col() - 1));
                    newFrontier.add(new Grid.Loc(loc.row() + rowStep, loc.col()));
                    newFrontier.add(new Grid.Loc(loc.row() + rowStep, loc.col() - 1));
                }
            }

            frontier = newFrontier;
        }

        for (var loc : toMove.stream().sorted((a, b) -> a.row() > b.row() ? -rowStep : rowStep).toList()) {
            state.grid[loc.row() + rowStep][loc.col()] = state.grid[loc.row()][loc.col()];
            state.grid[loc.row()][loc.col()] = '.';
        }

        state.grid[state.robot.row()][state.robot.col()] = '.';
        state.grid[cell.row()][state.robot.col()] = '@';
        state.robot = cell;
    }
}
