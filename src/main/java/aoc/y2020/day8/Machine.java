package aoc.y2020.day8;

import java.util.List;

public class Machine {
    private int acc = 0;
    private boolean finished = false;

    public int getAcc() {
        return acc;
    }

    public boolean didFinish() {
        return finished;
    }

    public void run(List<Instruction> prog) {
        var seen = new boolean[prog.size()];
        var ndx = 0;

        acc = 0;

        while (ndx < prog.size()) {
            var instr = prog.get(ndx);

            if (seen[ndx]) {
                finished = false;
                return;
            }

            seen[ndx] = true;

            if ("acc".equals(instr.getOp())) {
                acc += instr.getArg();
                ndx += 1;
            } else if ("jmp".equals(instr.getOp())) {
                ndx += instr.getArg();
            } else if ("nop".equals(instr.getOp())) {
                ndx += 1;
            }
        }

        finished = true;
    }
}
