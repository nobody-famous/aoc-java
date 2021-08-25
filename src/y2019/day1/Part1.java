package y2019.day1;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public int doWork() {
        int total = 0;

        for (var mass : masses) {
            total += findFuel(mass);
        }

        return total;
    }
}
