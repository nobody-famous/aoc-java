package aoc.y2019.day21;

import aoc.y2019.intcode.Machine;

public class Droid implements Machine.IO {
    private Machine mach;
    private Long lastValue;
    private Long nextInput;

    public Droid(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    public long read() {
        lastValue = null;

        while (lastValue == null) {
            mach.exec();
        }

        return lastValue;
    }

    public String readString() {
        var str = new StringBuilder();
        var done = false;

        while (!done) {
            var ch = (char) read();

            if (ch == '\n') {
                done = true;
            } else {
                str.append(ch);
            }
        }

        return str.toString();
    }

    public void send(String str) {
        for (var ch : str.toCharArray()) {
            send(ch);
        }
    }

    public void send(char ch) {
        nextInput = (long) ch;

        while (nextInput != null) {
            mach.exec();
        }
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
        lastValue = value;
    }
}
