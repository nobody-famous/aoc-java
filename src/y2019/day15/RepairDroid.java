package y2019.day15;

import y2019.intcode.Machine;

public class RepairDroid implements Machine.IO {
    public static final long North = 1;
    public static final long South = 2;
    public static final long West = 3;
    public static final long East = 4;

    public static final long Wall = 0;
    public static final long Open = 1;
    public static final long Oxygen = 2;

    private Machine mach;
    private Long nextInput;
    private Long lastOutput;

    public RepairDroid(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    public long move(long dir) {
        nextInput = dir;
        lastOutput = null;

        while (lastOutput == null) {
            mach.exec();
        }

        return lastOutput;
    }

    public long input() {
        return nextInput;
    }

    public void output(long value) {
        lastOutput = value;
    }
}
