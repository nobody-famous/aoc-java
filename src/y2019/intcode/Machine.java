package y2019.intcode;

import java.util.HashMap;
import java.util.Map;

public class Machine {
    private long[] prog;
    private IO io;

    private int ip = 0;
    private int relBase = 0;
    private Map<Integer, Long> mem = new HashMap<Integer, Long>();
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

    public void set(int addr, long value) {
        if (addr < prog.length) {
            prog[addr] = value;
        } else {
            mem.put(addr, value);
        }
    }

    public long get(int addr) {
        if (addr < prog.length) {
            return prog[addr];
        } else if (mem.containsKey(addr)) {
            return mem.get(addr);
        } else {
            return 0;
        }
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
        System.out.println("[" + ip + "] (" + get(ip) + "): " + msg);
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

    private class RelBase implements Instr {
        private long arg;

        public RelBase(long arg) {
            this.arg = arg;
        }

        public void process() {
            if (debug) {
                debugPrint("RelBase " + relBase + " + " + arg + " -> " + (relBase + arg));
            }

            relBase += arg;

            ip += 2;
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

            ip = (int) ((arg1 != 0) ? arg2 : ip + 3);
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

            ip = (int) ((arg1 == 0) ? arg2 : ip + 3);
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

            set(addr, (arg1 < arg2) ? 1 : 0);

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

            set(addr, (arg1 == arg2) ? 1 : 0);

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

            set(addr, io.input());

            if (debug) {
                debugPrint("INP [" + addr + "] = " + get(addr));
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
            set(addr, calculate(arg1, arg2));

            if (debug) {
                debugPrint("[" + addr + "] = " + get(addr));
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

    private long rdValue(int instr, int shift, long value) {
        var mode = (instr / shift) % 10;

        return switch (mode) {
            case 0 -> get((int) value);
            case 1 -> value;
            case 2 -> get((int) (relBase + value));
            default -> throw new RuntimeException("Unhandled read mode: " + mode);
        };
    }

    private int wrValue(int instr, int shift, long value) {
        var mode = (instr / shift) % 10;

        return switch (mode) {
            case 0 -> (int) value;
            case 2 -> (int) (relBase + value);
            default -> throw new RuntimeException("Unhandled write mode: " + mode);
        };
    }

    private Instr parseInstr() {
        var instr = (int) get(ip);
        var op = instr % 100;

        switch (op) {
            case 1:
                return new Add(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)),
                        wrValue(instr, 10000, get(ip + 3)));
            case 2:
                return new Mul(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)),
                        wrValue(instr, 10000, get(ip + 3)));
            case 3:
                return new Input(wrValue(instr, 100, get(ip + 1)));
            case 4:
                return new Output(rdValue(instr, 100, (int) get(ip + 1)));
            case 5:
                return new JumpTrue(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)));
            case 6:
                return new JumpFalse(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)));
            case 7:
                return new LessThan(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)),
                        wrValue(instr, 10000, get(ip + 3)));
            case 8:
                return new Equals(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)),
                        wrValue(instr, 10000, get(ip + 3)));
            case 9:
                return new RelBase(rdValue(instr, 100, get(ip + 1)));
            case 99:
                return new Halt();
            default:
                throw new RuntimeException("Unhandled op " + op);
        }
    }
}
