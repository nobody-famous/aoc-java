package y2019.day7;

import y2019.intcode.Machine;

public class Amp {
    private Machine mach;
    private IO io;

    private class IO implements Machine.IO {
        public Integer nextInput = null;
        public Integer lastOutput = null;

        public int input() {
            var inp = nextInput == null ? 0 : nextInput;

            nextInput = null;

            return inp;
        }

        public void output(int value) {
            lastOutput = value;
        }
    }

    public Amp(int[] prog) {
        io = new IO();
        mach = new Machine(prog, io);
    }

    public boolean isDone() {
        return mach.isHalted();
    }

    public void init(int input) {
        io.nextInput = input;

        while (!mach.isHalted() && io.nextInput != null) {
            mach.exec();
        }
    }

    public Integer runToOutput(int input) {
        io.nextInput = input;
        io.lastOutput = null;

        while (!mach.isHalted() && io.lastOutput == null) {
            mach.exec();
        }

        return io.lastOutput;
    }
}
