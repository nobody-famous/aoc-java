package aoc.y2019.intcode;

import java.util.HashMap;
import java.util.Map;

public class Machine {
    private final long[] prog;
    private final IO io;

    private int ip = 0;
    private int relBase = 0;
    private final Map<Integer, Long> mem = new HashMap<>();
    private boolean halted = false;
    private final boolean debug = false;

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

    public Machine(Machine copy, IO io) {
        this.prog = copy.prog.clone();
        this.io = io;
    }

    public void set(int address, long value) {
        if (address < prog.length) {
            prog[address] = value;
        } else {
            mem.put(address, value);
        }
    }

    public long get(int address) {
        if (address < prog.length) {
            return prog[address];
        } else if (mem.containsKey(address)) {
            return mem.get(address);
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
        private final long arg;

        public RelBase(long arg) {
            this.arg = arg;
        }

        public void process() {
            if (debug) {
                debugPrint("RelBase " + relBase + " + " + arg + " -> " + (relBase + arg));
            }

            relBase += (int) arg;

            ip += 2;
        }
    }

    private class JumpTrue implements Instr {
        private final long arg1;
        private final long arg2;

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
        private final long arg1;
        private final long arg2;

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
        private final long arg1;
        private final long arg2;
        private final int address;

        public LessThan(long arg1, long arg2, int address) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.address = address;
        }

        public void process() {
            if (debug) {
                debugPrint("[" + address + "] = " + arg1 + " < " + arg2);
            }

            set(address, (arg1 < arg2) ? 1 : 0);

            ip += 4;
        }
    }

    private class Equals implements Instr {
        private final long arg1;
        private final long arg2;
        private final int address;

        public Equals(long arg1, long arg2, int address) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.address = address;
        }

        public void process() {
            if (debug) {
                debugPrint("[" + address + "] = " + arg1 + " = " + arg2);
            }

            set(address, (arg1 == arg2) ? 1 : 0);

            ip += 4;
        }
    }

    private class Input implements Instr {
        private final int address;

        public Input(int address) {
            this.address = address;
        }

        public void process() {
            if (io == null) {
                throw new RuntimeException("Input: No IO set");
            }

            set(address, io.input());

            if (debug) {
                debugPrint("INP [" + address + "] = " + get(address));
            }

            ip += 2;
        }
    }

    private class Output implements Instr {
        private final long value;

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
        protected int address;

        public Math(long arg1, long arg2, int address) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.address = address;
        }

        protected abstract long calculate(long arg1, long arg2);

        public void process() {
            set(address, calculate(arg1, arg2));

            if (debug) {
                debugPrint("[" + address + "] = " + get(address));
            }

            ip += 4;
        }
    }

    private class Add extends Math {
        public Add(long arg1, long arg2, int address) {
            super(arg1, arg2, address);
        }

        protected long calculate(long arg1, long arg2) {
            return arg1 + arg2;
        }
    }

    private class Mul extends Math {
        public Mul(long arg1, long arg2, int address) {
            super(arg1, arg2, address);
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

        return switch (op) {
            case 1 ->
                    new Add(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)), wrValue(instr, 10000, get(ip + 3)));
            case 2 ->
                    new Mul(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)), wrValue(instr, 10000, get(ip + 3)));
            case 3 -> new Input(wrValue(instr, 100, get(ip + 1)));
            case 4 -> new Output(rdValue(instr, 100, (int) get(ip + 1)));
            case 5 -> new JumpTrue(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)));
            case 6 -> new JumpFalse(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)));
            case 7 ->
                    new LessThan(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)), wrValue(instr, 10000, get(ip + 3)));
            case 8 ->
                    new Equals(rdValue(instr, 100, get(ip + 1)), rdValue(instr, 1000, get(ip + 2)), wrValue(instr, 10000, get(ip + 3)));
            case 9 -> new RelBase(rdValue(instr, 100, get(ip + 1)));
            case 99 -> new Halt();
            default -> throw new RuntimeException("Unhandled op " + op);
        };
    }
}
