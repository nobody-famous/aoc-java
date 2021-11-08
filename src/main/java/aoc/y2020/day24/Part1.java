package aoc.y2020.day24;

public class Part1 extends Solver {
    public Part1(Direction[][] input, int expected) {
        super(input, expected);
    }

    public Integer run() {
        for (var dirs : input) {
            processMoves(dirs);
        }

        var sum = 0;
        for (var color : tiles.values()) {
            if (color == Color.BLACK) {
                sum += 1;
            }
        }

        return sum;
    }
}
