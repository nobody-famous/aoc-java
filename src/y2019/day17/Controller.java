package y2019.day17;

import java.util.ArrayList;
import java.util.List;

import y2019.intcode.Machine;

public class Controller implements Machine.IO {
    private Machine mach;
    private Long lastOutput;

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

    public String readLine() {
        var str = new StringBuilder();
        var ch = readChar();

        while (ch != '\n') {
            str.append(ch);
            ch = readChar();
        }

        return str.toString();
    }

    private char readChar() {
        lastOutput = null;

        while (lastOutput == null) {
            mach.exec();
        }

        return (char) lastOutput.longValue();
    }

    public long input() {
        return 0L;
    }

    public void output(long value) {
        lastOutput = value;
    }
}
