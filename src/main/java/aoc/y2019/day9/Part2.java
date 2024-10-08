package aoc.y2019.day9;

import java.util.List;

import aoc.utils.Problem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part2 extends Problem<Long> {
    private Parser parser = new Parser();

    public Part2(String fileName, long exp) {
        super(fileName, exp);
    }

    @Override
    public Long run(List<String> lines) {
        var prog = parser.parse(lines);
        var io = new MachIO(2);
        var mach = new Machine(prog, io);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return io.getLastOutput();
    }
}
