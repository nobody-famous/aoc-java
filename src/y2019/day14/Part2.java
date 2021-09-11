package y2019.day14;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    public long doWork() {
        var target = 1000000000000L;
        var low = 0L;
        var high = target / 2;
        var mid = high / 2;

        while (low < mid) {
            var ore = getOreForFuel(mid);

            if (ore > target) {
                high = mid;
            } else {
                low = mid;
            }

            mid = ((high - low) / 2) + low;
        }

        return mid;
    }
}
