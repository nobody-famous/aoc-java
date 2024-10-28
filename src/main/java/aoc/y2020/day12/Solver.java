package aoc.y2020.day12;

import aoc.y2020.Y2020Problem;

public abstract class Solver extends Y2020Problem<Long> {
    protected int x;
    protected int y;
    protected int dir;
    protected Instruction[] instrs;

    protected Solver(Instruction[] instrs, long expected) {
        super(expected);
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
        switch (instr.action()) {
        case 'N':
            north(instr.value());
            break;
        case 'S':
            south(instr.value());
            break;
        case 'E':
            east(instr.value());
            break;
        case 'W':
            west(instr.value());
            break;
        case 'L':
            left(instr.value());
            break;
        case 'R':
            right(instr.value());
            break;
        case 'F':
            forward(instr.value());
            break;
        }
    }

    protected long distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public Long run() {
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
