package y2020.day8;

public abstract class Solver {
    protected long run(Instruction[] prog) {
        var machine = new Machine();

        machine.run(prog);

        return machine.getAcc();
    }
}
