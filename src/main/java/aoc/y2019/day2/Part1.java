package aoc.y2019.day2;

import aoc.utils.Problem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part1 extends Problem<Long> {
    private Parser parser;

    public Part1(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Long run() {
        var prog = parser.parse();
        var mach = new Machine(prog);

        mach.set(1, 12);
        mach.set(2, 2);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return mach.get(0);
    }
}
