package aoc.y2019.day5;

import java.util.List;

import aoc.utils.LongProblem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part1 extends LongProblem {
    private final Parser parser = new Parser();

    @Override
    public long solve(List<String> lines) {
        var prog = parser.parse(lines);
        var io = new MachIO(1);
        var mach = new Machine(prog, io);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return io.getLastOutput();
    }
}
