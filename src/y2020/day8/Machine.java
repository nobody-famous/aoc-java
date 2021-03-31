package y2020.day8;

public class Machine {
    private long acc = 0;
    private boolean finished = false;

    public long getAcc() {
        return acc;
    }

    public boolean didFinish() {
        return finished;
    }

    public void run(Instruction[] prog) {
        var seen = new boolean[prog.length];
        var ndx = 0;

        acc = 0;

        while (ndx < prog.length) {
            var instr = prog[ndx];

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
