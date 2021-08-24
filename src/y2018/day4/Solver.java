package y2018.day4;

import java.util.HashMap;
import java.util.List;

import utils.Problem;

public abstract class Solver extends Problem<Integer> {
    protected Parser parser;
    protected Integer curGuard;
    protected Integer fallsAsleep;
    protected HashMap<Integer, int[]> guardMinutes;

    public Solver(String fileName, int exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    protected void addGuardMinutes(int guardId, int start, int end) {
        var minutes = guardMinutes.get(guardId);

        for (var minute = start; minute < end; minute += 1) {
            minutes[minute] += 1;
        }
    }

    protected void processRecord(BeginShiftRecord rec) {
        var id = rec.getGuardId();

        curGuard = id;

        if (!guardMinutes.containsKey(id)) {
            guardMinutes.put(id, new int[60]);
        }
    }

    protected void processRecord(FallAsleepRecord rec) {
        fallsAsleep = rec.date.minute();
    }

    protected void processRecord(WakesUpRecord rec) {
        addGuardMinutes(curGuard, fallsAsleep, rec.date.minute());
        fallsAsleep = null;
    }

    protected void processRecords(List<GuardRecord> records) {
        for (var rec : records) {
            if (rec instanceof BeginShiftRecord) {
                processRecord((BeginShiftRecord) rec);
            } else if (rec instanceof FallAsleepRecord) {
                processRecord((FallAsleepRecord) rec);
            } else if (rec instanceof WakesUpRecord) {
                processRecord((WakesUpRecord) rec);
            }
        }
    }
}
