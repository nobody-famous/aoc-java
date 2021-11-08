package aoc.y2019.day5;

import aoc.y2019.intcode.Machine;

public class MachIO implements Machine.IO {
    private long nextInput;
    private long lastOutput;

    public MachIO(long value) {
        this.nextInput = value;
    }

    public long input() {
        return nextInput;
    }

    public void output(long value) {
        lastOutput = value;
    }

    public long getLastOutput() {
        return lastOutput;
    }
}
