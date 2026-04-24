package aoc.y2024.day17;

import java.util.List;
import java.util.function.Consumer;

public class Computer {
    private long registerA = 0;
    private long registerB = 0;
    private long registerC = 0;
    private int pc = 0;
    private Consumer<Long> output;

    public static final int CMD_ADV = 0;
    public static final int CMD_BXL = 1;
    public static final int CMD_BST = 2;
    public static final int CMD_JNZ = 3;
    public static final int CMD_BXC = 4;
    public static final int CMD_OUT = 5;
    public static final int CMD_BDV = 6;
    public static final int CMD_CDV = 7;

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

            exec(program.get(pc), program.get(pc + 1));
        }
    }

    private int checkLoopCount(int count) {
        if (count > Utils.MAX_LOOPS) {
            throw new RuntimeException("Infinite loop detected");
        }

        return count + 1;
    }

    private void exec(int opcode, int operand) {
        switch (opcode) {
        case CMD_ADV:
            registerA = div(operand);
            pc += 2;
            break;
        case CMD_BXL:
            registerB ^= operand;
            pc += 2;
            break;
        case CMD_BST:
            registerB = combo(operand) % 8;
            pc += 2;
            break;
        case CMD_JNZ:
            jnz(operand);
            break;
        case CMD_BXC:
            registerB ^= registerC;
            pc += 2;
            break;
        case CMD_OUT:
            output.accept(combo(operand) % 8);
            pc += 2;
            break;
        case CMD_BDV:
            registerB = div(operand);
            pc += 2;
            break;
        case CMD_CDV:
            registerC = div(operand);
            pc += 2;
            break;
        default:
            throw new RuntimeException("Unhandled opcode " + opcode);
        }
    }

    private long div(int op) {
        return registerA >> combo(op);
    }

    private void jnz(int op) {
        if (registerA == 0) {
            pc += 2;
            return;
        }

        pc = op / 2;
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
