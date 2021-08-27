package y2019.intcode;

public class Machine {
    private int[] prog;
    private IO io;

    private int ip = 0;
    private boolean halted = false;

    public interface IO {
        int input();

        void output(int value);
    }

    public Machine(int[] prog) {
        this(prog, null);
    }

    public Machine(int[] prog, IO io) {
        this.prog = prog.clone();
        this.io = io;
    }

    public void set(int addr, int value) {
        prog[addr] = value;
    }

    public int get(int addr) {
        return prog[addr];
    }

    public boolean isHalted() {
        return halted;
    }

    public void exec() {
        var instr = parseInstr();

        instr.process();
    }

    private interface Instr {
        void process();
    }

    private class Halt implements Instr {
        public void process() {
            halted = true;
        }
    }

    private class Input implements Instr {
        private int addr;

        public Input(int addr) {
            this.addr = addr;
        }

        public void process() {
            if (io == null) {
                throw new RuntimeException("Input: No IO set");
            }

            prog[addr] = io.input();

            ip += 2;
        }
    }

    private class Output implements Instr {
        private int value;

        public Output(int value) {
            this.value = value;
        }

        public void process() {
            if (io == null) {
                throw new RuntimeException("Input: No IO set");
            }

            io.output(value);

            ip += 2;
        }
    }

    private abstract class Math implements Instr {
        protected int arg1;
        protected int arg2;
        protected int addr;

        public Math(int arg1, int arg2, int addr) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.addr = addr;
        }

        protected abstract int calculate(int arg1, int arg2);

        public void process() {
            prog[addr] = calculate(arg1, arg2);

            ip += 4;
        }
    }

    private class Add extends Math {
        public Add(int arg1, int arg2, int addr) {
            super(arg1, arg2, addr);
        }

        protected int calculate(int arg1, int arg2) {
            return arg1 + arg2;
        }
    }

    private class Mul extends Math {
        public Mul(int arg1, int arg2, int addr) {
            super(arg1, arg2, addr);
        }

        protected int calculate(int arg1, int arg2) {
            return arg1 * arg2;
        }
    }

    private int argValue(int instr, int shift, int value) {
        var mode = (instr / shift) % 10;

        return switch (mode) {
            case 0 -> prog[value];
            case 1 -> value;
            default -> throw new RuntimeException("Unhandled mode: " + mode);
        };
    }

    private Instr parseInstr() {
        var instr = prog[ip];
        var op = instr % 100;

        switch (op) {
            case 1:
                return new Add(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]), prog[ip + 3]);
            case 2:
                return new Mul(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]), prog[ip + 3]);
            case 3:
                return new Input(prog[ip + 1]);
            case 4:
                return new Output(argValue(instr, 100, prog[ip + 1]));
            case 99:
                return new Halt();
            default:
                throw new RuntimeException("Unhandled op " + op);
        }
    }
}
