package y2020.day24;

public class Part1 extends Solver {
    public Part1(Direction[][] input) {
        super(input);
    }

    public long solve() {
        for (var dirs : input) {
            processMoves(dirs);
        }

        var sum = 0L;
        for (var color : tiles.values()) {
            if (color == Color.BLACK) {
                sum += 1;
            }
        }

        return sum;
    }
}
