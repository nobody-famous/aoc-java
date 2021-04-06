package y2020.day17;

import utils.Problem;

public abstract class Solver implements Problem {
    protected char[][] input;
    protected char[][][] cube;
    protected char[][][] newCube;

    abstract void updateCell(int x, int y, int z);

    protected Solver(char[][] input) {
        this.input = input;
    }

    protected boolean onBoard(int x, int y, int z) {
        return x >= 0 && x < cube.length && y >= 0 && y < cube.length && z >= 0 && z < cube.length;
    }

    protected void update(int x, int y, int z, char value) {
        if (onBoard(x, y, z)) {
            newCube[x][y][z] = value;
        }
    }

    protected char lookup(int x, int y, int z) {
        return onBoard(x, y, z) ? cube[x][y][z] : '\0';
    }

    protected long countActive() {
        var count = 0L;
        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    if (cube[x][y][z] == '#') {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }

    protected int countNeighbors(int x, int y, int z) {
        var count = 0;

        for (var dx = x - 1; dx <= x + 1; dx += 1) {
            for (var dy = y - 1; dy <= y + 1; dy += 1) {
                for (var dz = z - 1; dz <= z + 1; dz += 1) {
                    if (!onBoard(x, y, z) || (x == dx && y == dy && z == dz)) {
                        continue;
                    }

                    if (lookup(dx, dy, dz) == '#') {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }

    protected void buildCube(int cycles) {
        var size = input.length + (cycles * 2);

        cube = new char[size][size][size];
        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    cube[x][y][z] = '.';
                }
            }
        }

        var z = size / 2;
        var x = (size / 2) - (input.length / 2);
        for (var inX = 0; inX < input.length; inX += 1) {
            var y = (size / 2) - (input.length / 2);

            for (var inY = 0; inY < input.length; inY += 1) {
                cube[x][y][z] = input[inX][inY];
                y += 1;
            }

            x += 1;
        }
    }

    private char[][][] copyCube() {
        var copy = new char[cube.length][cube.length][cube.length];

        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    copy[x][y][z] = cube[x][y][z];
                }
            }
        }

        return copy;
    }

    protected void runCycle() {
        newCube = copyCube();

        for (var x = 0; x < cube.length; x += 1) {
            for (var y = 0; y < cube.length; y += 1) {
                for (var z = 0; z < cube.length; z += 1) {
                    updateCell(x, y, z);
                }
            }
        }

        cube = newCube;
    }
}
