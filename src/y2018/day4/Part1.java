package y2018.day4;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    private int countMinutes(int[] minutes) {
        int count = 0;

        for (var minute : minutes) {
            count += minute;
        }

        return count;
    }

    private int findGuard() {
        var guard = 0;
        var most = 0;

        for (var entry : guardMinutes.entrySet()) {
            var count = countMinutes(entry.getValue());

            if (count > most) {
                guard = entry.getKey();
                most = count;
            }
        }

        return guard;
    }

    private int findMinute(int guard) {
        var minutes = guardMinutes.get(guard);
        var most = 0;
        var mostMinute = 0;

        for (var minute = 0; minute < minutes.length; minute += 1) {
            if (minutes[minute] > most) {
                most = minutes[minute];
                mostMinute = minute;
            }
        }

        return mostMinute;
    }

    public int doWork() {
        var guard = findGuard();
        var minute = findMinute(guard);

        return guard * minute;
    }
}
