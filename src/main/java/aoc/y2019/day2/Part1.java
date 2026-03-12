package aoc.y2019.day2;

import java.util.List;

import aoc.utils.LongProblem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part1 extends LongProblem {
    private final Parser parser = new Parser();

    @Override
    public long solve(List<String> lines) {
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
