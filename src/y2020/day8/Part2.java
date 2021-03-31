package y2020.day8;

public class Part2 {
    private boolean tryRun(Machine m, Instruction[] prog, int ndx, String before, String after) {
        prog[ndx].setOp(after);

        m.run(prog);

        prog[ndx].setOp(before);

        return m.didFinish();
    }

    public long solve(Instruction[] prog) {
        var machine = new Machine();

        for (var ndx = 0; ndx < prog.length; ndx += 1) {
            var instr = prog[ndx];
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

    public static void main(String[] args) {
        var solver = new Part2();
        var answer = solver.solve(Input.puzzle);

        System.out.println(answer);
    }
}
