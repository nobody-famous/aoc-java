package aoc.y2020.day8;

import java.util.List;

import aoc.utils.AocProblem;

public class Part2 implements AocProblem<Integer> {
    private boolean tryRun(Machine m, List<Instruction> prog, int ndx, String before, String after) {
        prog.get(ndx).setOp(after);

        m.run(prog);

        prog.get(ndx).setOp(before);

        return m.didFinish();
    }

    @Override
    public Integer solve(List<String> lines) {
        var prog = new Parser().parse(lines);
        var machine = new Machine();

        for (var ndx = 0; ndx < prog.size(); ndx += 1) {
            var instr = prog.get(ndx);
            var done = false;

            if ("jmp".equals(instr.getOp())) {
                done = tryRun(machine, prog, ndx, "jmp", "nop");
            } else if ("nop".equals(instr.getOp())) {
                done = tryRun(machine, prog, ndx, "nop", "jmp");
            }

            if (done) {
                break;
            }
        }

        return machine.getAcc();
    }
}
