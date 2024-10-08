package aoc.y2020.day8;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected Instruction[] prog;

    protected Solver(Instruction[] prog, long expected) {
        super(expected);
        this.prog = prog;
    }

    protected long runProgram(Instruction[] prog) {
        var machine = new Machine();

        machine.run(prog);

        return machine.getAcc();
    }
}
