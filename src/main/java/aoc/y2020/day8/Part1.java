package aoc.y2020.day8;

import java.util.List;

import aoc.utils.AocProblem;

public class Part1 implements AocProblem<Integer> {
    @Override
    public Integer solve(List<String> lines) {
        var prog = new Parser().parse(lines);
        var machine = new Machine();

        machine.run(prog);

        return machine.getAcc();
    }
}
