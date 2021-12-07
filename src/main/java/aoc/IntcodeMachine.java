package aoc;

import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class IntcodeMachine implements Machine.IO {
    private Machine mach;

    public IntcodeMachine(long[] prog) {
        this.mach = new Machine(prog, this);
    }

    @Override
    public long input() {
        System.out.println("INPUT");
        throw new RuntimeException("Need input");
    }

    @Override
    public void output(long value) {
        System.out.print((char) value);
    }

    public void run() {
        while (!mach.isHalted()) {
            mach.exec();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please give an input file");
            return;
        }

        var parser = new Parser(args[0]);
        var prog = parser.parse();
        var mach = new IntcodeMachine(prog);

        mach.run();
    }
}
