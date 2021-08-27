package y2019.day5;

import y2019.intcode.Machine;

public class MachIO implements Machine.IO {
    private int nextInput;
    private int lastOutput;

    public MachIO(int value) {
        this.nextInput = value;
    }

    public int input() {
        return nextInput;
    }

    public void output(int value) {
        lastOutput = value;
    }

    public int getLastOutput() {
        return lastOutput;
    }
}
