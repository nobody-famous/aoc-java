package aoc.y2020.day12;

import java.util.List;

import aoc.utils.AocProblem;

public abstract class Solver implements AocProblem<Integer> {
    protected int x;
    protected int y;
    protected int dir;

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

    protected int distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public Integer solve(List<String> lines) {
        var instrs = new Parser().parse(lines);
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
