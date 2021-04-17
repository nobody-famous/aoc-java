package y2020.day8;

import utils.Problem;

public abstract class Solver extends Problem<Long> {
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
