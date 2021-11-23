package aoc.y2019.day25;

import aoc.y2019.intcode.Machine;

public class Droid implements Machine.IO {
    private Machine mach;
    private Long lastOutput;
    private Long nextInput;

    public Droid(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    public boolean isHalted() {
        return mach.isHalted();
    }

    public void writeLine(String line) {
        for (var ch : line.toCharArray()) {
            writeChar(ch);
        }
    }

    private void writeChar(char ch) {
        nextInput = (long) ch;

        while (!mach.isHalted() && nextInput != null) {
            mach.exec();
        }
    }

    public String readLine() {
        var sb = new StringBuilder();
        var ch = '\0';

        while (ch != '\n') {
            ch = readChar();

            if (ch != '\n') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public char readChar() {
        lastOutput = null;

        while (!mach.isHalted() && lastOutput == null) {
            mach.exec();
        }

        return mach.isHalted() ? '\n' : (char) lastOutput.longValue();
    }

    @Override
    public long input() {
        if (nextInput == null) {
            throw new RuntimeException("No input");
        }

        var value = nextInput;

        nextInput = null;

        return value;
    }

    @Override
    public void output(long value) {
        lastOutput = value;
    }
}
