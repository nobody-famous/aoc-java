package y2019.intcode;

public class Machine {
    private long[] prog;
    private IO io;

    private int ip = 0;
    private boolean halted = false;
    private boolean debug = false;

    public interface IO {
        long input();

        void output(long value);
    }

    public Machine(long[] prog) {
        this(prog, null);
    }

    public Machine(long[] prog, IO io) {
        this.prog = prog.clone();
        this.io = io;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void set(int addr, int value) {
        prog[addr] = value;
    }

    public long get(int addr) {
        return prog[addr];
    }

    public boolean isHalted() {
        return halted;
    }

    public void exec() {
        if (halted) {
            System.out.println("HALTED");
            return;
        }

        var instr = parseInstr();

        instr.process();
    }

    private interface Instr {
        void process();
    }

    private void debugPrint(String msg) {
        System.out.println("[" + ip + "] (" + prog[ip] + "): " + msg);
    }

    private class Halt implements Instr {
        public void process() {
            if (debug) {
                debugPrint("HALT");
            }

            halted = true;
            ip += 1;
        }
    }

    private class JumpTrue implements Instr {
        private long arg1;
        private long arg2;

        public JumpTrue(long arg1, long arg2) {
            this.arg1 = arg1;
            this.arg2 = arg2;
        }

        public void process() {
            if (debug) {
                debugPrint("JT " + arg1 + " -> " + arg2);
            }

            ip = (arg1 != 0) ? (int) arg2 : (int) ip + 3;
        }
    }

    private class JumpFalse implements Instr {
        private long arg1;
        private long arg2;

        public JumpFalse(long arg1, long arg2) {
            this.arg1 = arg1;
            this.arg2 = arg2;
        }

        public void process() {
            if (debug) {
                debugPrint("JF " + arg1 + " -> " + arg2);
            }

            ip = (arg1 == 0) ? (int) arg2 : (int) ip + 3;
        }
    }

    private class LessThan implements Instr {
        private long arg1;
        private long arg2;
        private int addr;

        public LessThan(long arg1, long arg2, int addr) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.addr = addr;
        }

        public void process() {
            if (debug) {
                debugPrint("[" + addr + "] = " + arg1 + " < " + arg2);
            }

            prog[addr] = (arg1 < arg2) ? 1 : 0;

            ip += 4;
        }
    }

    private class Equals implements Instr {
        private long arg1;
        private long arg2;
        private int addr;

        public Equals(long arg1, long arg2, int addr) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.addr = addr;
        }

        public void process() {
            if (debug) {
                debugPrint("[" + addr + "] = " + arg1 + " = " + arg2);
            }

            prog[addr] = (arg1 == arg2) ? 1 : 0;

            ip += 4;
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

            if (debug) {
                debugPrint("INP [" + addr + "] = " + prog[addr]);
            }

            ip += 2;
        }
    }

    private class Output implements Instr {
        private long value;

        public Output(long value) {
            this.value = value;
        }

        public void process() {
            if (io == null) {
                throw new RuntimeException("Input: No IO set");
            }

            if (debug) {
                debugPrint("OUT " + value);
            }

            io.output(value);

            ip += 2;
        }
    }

    private abstract class Math implements Instr {
        protected long arg1;
        protected long arg2;
        protected int addr;

        public Math(long arg1, long arg2, int addr) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.addr = addr;
        }

        protected abstract long calculate(long arg1, long arg2);

        public void process() {
            prog[addr] = calculate(arg1, arg2);

            if (debug) {
                debugPrint("[" + addr + "] = " + prog[addr]);
            }

            ip += 4;
        }
    }

    private class Add extends Math {
        public Add(long arg1, long arg2, int addr) {
            super(arg1, arg2, addr);
        }

        protected long calculate(long arg1, long arg2) {
            return arg1 + arg2;
        }
    }

    private class Mul extends Math {
        public Mul(long arg1, long arg2, int addr) {
            super(arg1, arg2, addr);
        }

        protected long calculate(long arg1, long arg2) {
            return arg1 * arg2;
        }
    }

    private long argValue(long instr, int shift, long value) {
        var mode = (instr / shift) % 10;

        return switch ((int) mode) {
            case 0 -> prog[(int) value];
            case 1 -> value;
            default -> throw new RuntimeException("Unhandled mode: " + mode);
        };
    }

    private Instr parseInstr() {
        var instr = prog[ip];
        var op = instr % 100;

        switch ((int) op) {
            case 1:
                return new Add(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]),
                        (int) prog[ip + 3]);
            case 2:
                return new Mul(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]),
                        (int) prog[ip + 3]);
            case 3:
                return new Input((int) prog[ip + 1]);
            case 4:
                return new Output(argValue(instr, 100, prog[ip + 1]));
            case 5:
                return new JumpTrue(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]));
            case 6:
                return new JumpFalse(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]));
            case 7:
                return new LessThan(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]),
                        (int) prog[ip + 3]);
            case 8:
                return new Equals(argValue(instr, 100, prog[ip + 1]), argValue(instr, 1000, prog[ip + 2]),
                        (int) prog[ip + 3]);
            case 99:
                return new Halt();
            default:
                throw new RuntimeException("Unhandled op " + op);
        }
    }
}
