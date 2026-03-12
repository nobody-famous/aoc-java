package aoc.y2019.day1;

public class Part1 extends Solver {
    public int doWork() {
        int total = 0;

        for (var mass : masses) {
            total += findFuel(mass);
        }

        return total;
    }
}
