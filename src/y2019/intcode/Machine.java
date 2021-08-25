package y2019.intcode;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Integer> prog;

    private int ip = 0;
    private boolean halted = false;

    public Machine(List<Integer> prog) {
        this.prog = new ArrayList<Integer>();

        for (var op : prog) {
            this.prog.add(op);
        }
    }

    public void set(int addr, int value) {
        prog.set(addr, value);
    }

    public int get(int addr) {
        return prog.get(addr);
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
            var value1 = prog.get(arg1);
            var value2 = prog.get(arg2);

            prog.set(addr, calculate(value1, value2));

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
        var instr = prog.get(ip);
        var op = instr % 100;

        switch (op) {
            case 1:
                return new Add(prog.get(ip + 1), prog.get(ip + 2), prog.get(ip + 3));
            case 2:
                return new Mul(prog.get(ip + 1), prog.get(ip + 2), prog.get(ip + 3));
            case 99:
                return new Halt();
            default:
                throw new RuntimeException("Unhandled op " + op);
        }
    }
}
