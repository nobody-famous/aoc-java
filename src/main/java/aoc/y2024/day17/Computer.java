package aoc.y2024.day17;

import java.util.List;
import java.util.function.Consumer;

public class Computer {
    private static final int MAX_LOOPS = 1000;

    private long registerA = 0;
    private long registerB = 0;
    private long registerC = 0;
    private int pc = 0;
    private Consumer<Long> output;

    public Computer(Consumer<Long> output) {
        this.output = output;
    }

    public void init(long a, long b, long c) {
        registerA = a;
        registerB = b;
        registerC = c;
    }

    public void run(List<Integer> program) {
        var loopCount = 0;

        pc = 0;

        while (pc < program.size()) {
            loopCount = checkLoopCount(loopCount);

            var opcode = program.get(pc);
            var operand = program.get(pc + 1);

            exec(opcode, operand);
        }
    }

    private int checkLoopCount(int count) {
        if (count > MAX_LOOPS) {
            throw new RuntimeException("Infinite loop detected");
        }

        return count + 1;
    }

    private void exec(int opcode, int operand) {
        switch (opcode) {
        case 0:
            registerA = adv(operand);
            pc += 2;
            break;
        case 1:
            registerB ^= operand;
            pc += 2;
            break;
        case 2:
            registerB = combo(operand) % 8;
            pc += 2;
            break;
        case 3:
            jnz(operand);
            break;
        case 4:
            registerB ^= registerC;
            pc += 2;
            break;
        case 5:
            output.accept(combo(operand) % 8);
            pc += 2;
            break;
        case 6:
            registerB = adv(operand);
            pc += 2;
            break;
        case 7:
            registerC = adv(operand);
            pc += 2;
            break;
        default:
            throw new RuntimeException("Unhandled opcode " + opcode);
        }
    }

    private long adv(int op) {
        var den = 1 << combo(op);

        return registerA / den;
    }

    private void jnz(int op) {
        if (registerA == 0) {
            pc += 2;
            return;
        }

        pc = op;
    }

    private long combo(int op) {
        return switch (op) {
        case 0, 1, 2, 3 -> op;
        case 4 -> registerA;
        case 5 -> registerB;
        case 6 -> registerC;
        default -> throw new RuntimeException("Invalid combo op: " + op);
        };
    }
}
