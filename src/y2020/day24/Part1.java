package y2020.day24;

import utils.Problem;

public class Part1 implements Problem {
    private Direction[][] input;

    public Part1(Direction[][] input) {
        this.input = input;
    }

    public long solve() {
        System.out.println("Part 1");

        for (var dir : input[0]) {
            System.out.print(" " + dir);
        }
        System.out.println();

        return 0L;
    }
}
