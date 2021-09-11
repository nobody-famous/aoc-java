package y2019.day14;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    public long doWork() {
        return getOreForFuel(1);
    }
}
