package y2019.intcode;

public class Machine {
    private int[] prog;

    private int ip = 0;
    private boolean halted = false;

    public Machine(int[] prog) {
        this.prog = prog.clone();
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
            var value1 = prog[arg1];
            var value2 = prog[arg2];

            prog[addr] = calculate(value1, value2);

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

    private Instr parseInstr() {
        var instr = prog[ip];
        var op = instr % 100;

        switch (op) {
            case 1:
                return new Add(prog[ip + 1], prog[ip + 2], prog[ip + 3]);
            case 2:
                return new Mul(prog[ip + 1], prog[ip + 2], prog[ip + 3]);
            case 99:
                return new Halt();
            default:
                throw new RuntimeException("Unhandled op " + op);
        }
    }
}
