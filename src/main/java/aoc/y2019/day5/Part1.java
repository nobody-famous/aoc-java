package aoc.y2019.day5;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part1 implements AocProblem<Long> {
    private final Parser parser = new Parser();

    @Override
    public Long solve(List<String> lines) {
        var prog = parser.parse(lines);
        var io = new MachIO(1);
        var mach = new Machine(prog, io);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return io.getLastOutput();
    }
}
