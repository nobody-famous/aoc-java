package aoc.y2018.day4;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    private int[] findGuardAndMinute() {
        var guard = 0;
        var minute = 0;
        var most = 0;

        for (var entry : guardMinutes.entrySet()) {
            var minutes = entry.getValue();

            for (var ndx = 0; ndx < minutes.length; ndx += 1) {
                if (minutes[ndx] > most) {
                    most = minutes[ndx];
                    minute = ndx;
                    guard = entry.getKey();
                }
            }
        }

        return new int[] { guard, minute };
    }

    public int doWork() {
        var values = findGuardAndMinute();

        return values[0] * values[1];
    }
}
