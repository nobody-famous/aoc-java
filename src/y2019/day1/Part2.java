package y2019.day1;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private int totalFuel(int mass) {
        var fuel = findFuel(mass);
        var total = 0;

        while (fuel > 0) {
            total += fuel;
            fuel = findFuel(fuel);
        }

        return total;
    }

    public int doWork() {
        int total = 0;

        for (var mass : masses) {
            total += totalFuel(mass);
        }

        return total;
    }
}
