package aoc.y2018.day4;

public class BeginShiftRecord extends GuardRecord {
    private int guard;

    public BeginShiftRecord(RecordDate date, int guard) {
        super(date);

        this.guard = guard;
    }

    public int getGuardId() {
        return guard;
    }
}
