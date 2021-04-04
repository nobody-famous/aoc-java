package y2020.day14;

public class Memory implements Op {
    private long addr;
    private long value;

    public Memory(long addr, long value) {
        this.addr = addr;
        this.value = value;
    }

    public Type getType() {
        return Type.MEMORY;
    }

    public long getAddr() {
        return addr;
    }

    public long getValue() {
        return value;
    }
}
