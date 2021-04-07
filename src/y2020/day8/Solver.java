package y2020.day8;

import utils.Problem;

public abstract class Solver implements Problem {
    protected Instruction[] prog;

    protected Solver(Instruction[] prog) {
        this.prog = prog;
    }

    protected long run(Instruction[] prog) {
        var machine = new Machine();

        machine.run(prog);

        return machine.getAcc();
    }
}
