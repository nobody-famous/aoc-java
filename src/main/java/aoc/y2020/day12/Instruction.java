package aoc.y2020.day12;

public class Instruction {
    private char action;
    private int value;

    public Instruction(char action, int value) {
        this.action = action;
        this.value = value;
    }

    public char getAction() {
        return action;
    }

    public int getValue() {
        return value;
    }
}
