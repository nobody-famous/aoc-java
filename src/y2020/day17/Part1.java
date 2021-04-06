package y2020.day17;

public class Part1 extends Solver {
    private int cycles = 6;

    public Part1(char[][] input) {
        super(input);
    }

    protected void updateCell(int x, int y, int z) {
        var value = lookup(x, y, z);
        var count = countNeighbors(x, y, z);

        if (value == '#' && count != 2 && count != 3) {
            update(x, y, z, '.');
        } else if (value == '.' && count == 3) {
            update(x, y, z, '#');
        }
    }

    public long solve() {
        buildCube(cycles);

        for (var cycle = 0; cycle < cycles; cycle += 1) {
            runCycle();
        }

        var answer = countActive();

        System.out.println(answer);
        return answer;
    }
}
