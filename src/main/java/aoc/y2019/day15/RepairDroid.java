package aoc.y2019.day15;

import aoc.y2019.intcode.Machine;

public class RepairDroid implements Machine.IO {
    public static final int North = 1;
    public static final int South = 2;
    public static final int West = 3;
    public static final int East = 4;

    public static final int Wall = 0;
    public static final int Open = 1;
    public static final int Oxygen = 2;

    private Machine mach;
    private Long nextInput;
    private Long lastOutput;

    public RepairDroid(RepairDroid clone) {
        this.mach = new Machine(clone.mach, this);
    }

    public RepairDroid(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    public int move(int dir) {
        nextInput = (long) dir;
        lastOutput = null;

        while (lastOutput == null) {
            mach.exec();
        }

        return (int) lastOutput.longValue();
    }

    public long input() {
        return nextInput;
    }

    public void output(long value) {
        lastOutput = value;
    }
}
