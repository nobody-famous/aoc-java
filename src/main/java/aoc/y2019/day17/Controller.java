package aoc.y2019.day17;

import java.util.ArrayList;
import java.util.List;

import aoc.y2019.intcode.Machine;

public class Controller implements Machine.IO {
    private Machine mach;
    private Long lastOutput;
    private Long nextInput;

    public Controller(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    public void wakeRobot() {
        mach.set(0, 2);
    }

    public List<String> readCamera() {
        var output = new ArrayList<String>();

        var line = readLine();
        while (line.length() > 0) {
            output.add(line);
            line = readLine();
        }

        return output;
    }

    public void writeLine(String str) {
        for (var ch : str.toCharArray()) {
            writeChar((long) ch);
        }

        writeChar(10);
    }

    public String readLine() {
        var str = new StringBuilder();
        var ch = readChar();

        while (ch != '\n') {
            str.append(ch);
            ch = readChar();
        }

        return str.toString();
    }

    private void writeChar(long ch) {
        nextInput = ch;

        while (nextInput != null) {
            mach.exec();
        }
    }

    public long readValue() {
        lastOutput = null;

        while (lastOutput == null) {
            mach.exec();
        }

        return lastOutput.longValue();
    }

    private char readChar() {
        lastOutput = null;

        while (lastOutput == null) {
            mach.exec();
        }

        return (char) lastOutput.longValue();
    }

    public long input() {
        var value = nextInput;

        nextInput = null;

        return value;
    }

    public void output(long value) {
        lastOutput = value;
    }
}
