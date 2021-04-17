package y2020.day17;

import utils.Problem;

public class Part2 extends Problem<Long> {
    private char[][] input;
    private char[][][][] cube;
    private char[][][][] newCube;
    private int cycles = 6;

    public Part2(char[][] input, long expected) {
        super(expected);
        this.input = input;
    }

    private void updateCell(int x, int y, int z, int w) {
        var value = lookup(x, y, z, w);
        var count = countNeighbors(x, y, z, w);

        if (value == '#' && count != 2 && count != 3) {
            update(x, y, z, w, '.');
        } else if (value == '.' && count == 3) {
            update(x, y, z, w, '#');
        }
    }

    private boolean onBoard(int x, int y, int z, int w) {
        return x >= 0 && x < cube.length && y >= 0 && y < cube.length && z >= 0 && z < cube.length && w >= 0
                && w < cube.length;
    }

    private void update(int x, int y, int z, int w, char value) {
        if (onBoard(x, y, z, w)) {
            newCube[x][y][z][w] = value;
        }
    }

    private char lookup(int x, int y, int z, int w) {
        return onBoard(x, y, z, w) ? cube[x][y][z][w] : '\0';
    }

    private long countActive() {
        var count = 0L;
        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    for (var w = 0; w < cube.length; w += 1) {
                        if (cube[x][y][z][w] == '#') {
                            count += 1;
                        }
                    }
                }
            }
        }

        return count;
    }

    private int countNeighbors(int x, int y, int z, int w) {
        var count = 0;

        for (var dx = x - 1; dx <= x + 1; dx += 1) {
            for (var dy = y - 1; dy <= y + 1; dy += 1) {
                for (var dz = z - 1; dz <= z + 1; dz += 1) {
                    for (var dw = w - 1; dw <= w + 1; dw += 1) {
                        if (!onBoard(x, y, z, w) || (x == dx && y == dy && z == dz && w == dw)) {
                            continue;
                        }

                        if (lookup(dx, dy, dz, dw) == '#') {
                            count += 1;
                        }
                    }
                }
            }
        }

        return count;
    }

    private void buildCube(int cycles) {
        var size = input.length + (cycles * 2);

        cube = new char[size][size][size][size];
        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    for (var w = 0; w < cube.length; w += 1) {
                        cube[x][y][z][w] = '.';
                    }
                }
            }
        }

        var z = size / 2;
        var w = size / 2;
        var x = (size / 2) - (input.length / 2);
        for (var inX = 0; inX < input.length; inX += 1) {
            var y = (size / 2) - (input.length / 2);

            for (var inY = 0; inY < input.length; inY += 1) {
                cube[x][y][z][w] = input[inX][inY];
                y += 1;
            }

            x += 1;
        }
    }

    private char[][][][] copyCube() {
        var copy = new char[cube.length][cube.length][cube.length][cube.length];

        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    for (var w = 0; w < cube.length; w += 1) {
                        copy[x][y][z][w] = cube[x][y][z][w];
                    }
                }
            }
        }

        return copy;
    }

    private void runCycle() {
        newCube = copyCube();

        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    for (var w = 0; w < cube.length; w += 1) {
                        updateCell(x, y, z, w);
                    }
                }
            }
        }

        cube = newCube;
    }

    public Long run() {
        buildCube(cycles);

        for (var cycle = 0; cycle < cycles; cycle += 1) {
            runCycle();
        }

        var answer = countActive();

        return answer;
    }
}
