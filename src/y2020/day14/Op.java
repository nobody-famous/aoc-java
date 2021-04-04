package y2020.day14;

public interface Op {
    public enum Type {
        MASK, MEMORY
    };

    public abstract Type getType();
}
