package aoc.y2019.day2;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part1 implements AocProblem<Long> {
    private final Parser parser = new Parser();

    @Override
    public Long solve(List<String> lines) {
        var prog = parser.parse(lines);
        var mach = new Machine(prog);

        mach.set(1, 12);
        mach.set(2, 2);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return mach.get(0);
    }
}
