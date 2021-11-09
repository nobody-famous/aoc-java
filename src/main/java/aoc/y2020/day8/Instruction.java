package aoc.y2020.day8;

public class Instruction {
    private String op;
    private int arg;

    public Instruction(String op, int arg) {
        this.op = op;
        this.arg = arg;
    }

    public String getOp() {
        return op;
    }

    public int getArg() {
        return arg;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
