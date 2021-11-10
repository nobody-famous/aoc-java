package aoc.y2019.day19;

import aoc.y2019.intcode.Machine;

public class Drone implements Machine.IO {
    private long[] prog;
    private Long nextInput = null;
    private Long lastOutput = null;

    public static final int STATIC = 0;
    public static final int PULLED = 1;

    public Drone(long[] prog) {
        this.prog = prog;
    }

    public int sendRequest(int x, int y) {
        var mach = new Machine(prog, this);

        sendInput(mach, x);
        sendInput(mach, y);

        var resp = getResponse(mach);

        return resp;
    }

    private int getResponse(Machine mach) {
        lastOutput = null;

        while (!mach.isHalted() && lastOutput == null) {
            mach.exec();
        }

        return (int) lastOutput.longValue();
    }

    private void sendInput(Machine mach, int value) {
        nextInput = (long) value;

        while (!mach.isHalted() && nextInput != null) {
            mach.exec();
        }
    }

    public long input() {
        if (nextInput == null) {
            throw new RuntimeException("No input");
        }

        var value = nextInput;

        nextInput = null;

        return value;
    }

    public void output(long value) {
        lastOutput = value;
    }
}
