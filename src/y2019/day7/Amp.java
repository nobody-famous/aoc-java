package y2019.day7;

import y2019.intcode.Machine;

public class Amp {
    private Machine mach;
    private IO io;

    private class IO implements Machine.IO {
        public Long nextInput = null;
        public Long lastOutput = null;

        public long input() {
            var inp = nextInput == null ? 0 : nextInput;

            nextInput = null;

            return inp;
        }

        public void output(long value) {
            lastOutput = value;
        }
    }

    public Amp(long[] prog) {
        io = new IO();
        mach = new Machine(prog, io);
    }

    public boolean isDone() {
        return mach.isHalted();
    }

    public void init(long input) {
        io.nextInput = input;

        while (!mach.isHalted() && io.nextInput != null) {
            mach.exec();
        }
    }

    public Long runToOutput(long input) {
        io.nextInput = input;
        io.lastOutput = null;

        while (!mach.isHalted() && io.lastOutput == null) {
            mach.exec();
        }

        return io.lastOutput;
    }
}
