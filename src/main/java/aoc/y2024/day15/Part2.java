package aoc.y2024.day15;

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
        throw new RuntimeException("not done yet");
    }

    private void moveRight(State state) {
        throw new RuntimeException("not done yet");
    }

    private void moveUp(State state) {
        throw new RuntimeException("not done yet");
    }

    private void moveDown(State state) {
        throw new RuntimeException("not done yet");
    }
}
