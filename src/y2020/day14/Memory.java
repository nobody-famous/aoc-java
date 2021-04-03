package y2020.day14;

public class Memory implements Op {
    private int addr;
    private int value;

    public Memory(int addr, int value) {
        this.addr = addr;
        this.value = value;
    }

    public Type getType() {
        return Type.MEMORY;
    }

    public int getAddr() {
        return addr;
    }

    public int getValue() {
        return value;
    }
}
