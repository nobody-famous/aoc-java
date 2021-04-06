package y2020.day12;

import utils.Problem;

public abstract class Solver implements Problem {
    protected int x;
    protected int y;
    protected int dir;
    protected Instruction[] instrs;

    protected Solver(Instruction[] instrs) {
        this.instrs = instrs;
    }

    abstract void north(int value);

    abstract void south(int value);

    abstract void east(int value);

    abstract void west(int value);

    abstract void left(int value);

    abstract void right(int value);

    abstract void forward(int value);

    protected void process(Instruction instr) {
        switch (instr.getAction()) {
        case 'N':
            north(instr.getValue());
            break;
        case 'S':
            south(instr.getValue());
            break;
        case 'E':
            east(instr.getValue());
            break;
        case 'W':
            west(instr.getValue());
            break;
        case 'L':
            left(instr.getValue());
            break;
        case 'R':
            right(instr.getValue());
            break;
        case 'F':
            forward(instr.getValue());
            break;
        }
    }

    protected long distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public long solve() {
        x = 0;
        y = 0;
        dir = 1;

        for (var instr : instrs) {
            process(instr);
        }

        var answer = distance(x, y);

        return answer;
    }
}
