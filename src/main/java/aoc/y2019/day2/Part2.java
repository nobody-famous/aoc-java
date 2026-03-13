package aoc.y2019.day2;

import java.util.List;

import aoc.utils.AocProblem;
import aoc.y2019.intcode.Machine;
import aoc.y2019.intcode.Parser;

public class Part2 implements AocProblem<Long> {
    private final Parser parser = new Parser();

    private long runMachine(long[] prog, int noun, int verb) {
        var mach = new Machine(prog);

        mach.set(1, noun);
        mach.set(2, verb);

        while (!mach.isHalted()) {
            mach.exec();
        }

        return mach.get(0);
    }

    @Override
    public Long solve(List<String> lines) {
        var prog = parser.parse(lines);
        var target = 19690720;
        var answer = 0L;

        for (var noun = 0; answer == 0 && noun < 100; noun += 1) {
            for (var verb = 0; answer == 0 && verb < 100; verb += 1) {
                if (runMachine(prog, noun, verb) == target) {
                    answer = (100L * noun) + verb;
                }
            }
        }

        return answer;
    }
}
