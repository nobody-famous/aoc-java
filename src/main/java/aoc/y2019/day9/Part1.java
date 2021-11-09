package aoc.y2019.day9;

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
        var io = new MachIO(1);
        var mach = new Machine(prog, io);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return io.getLastOutput();
    }
}
