package aoc.y2019.day21;

import java.util.List;

import aoc.utils.IntProblem;
import aoc.y2019.intcode.Parser;

public abstract class Solver extends IntProblem {
    private final Parser parser = new Parser();
    private Droid droid;

    protected abstract String[] getInstructionList();

    protected abstract String getSpeed();

    protected abstract String getSpeedLabel();

    private void readPrompt() {
        var prompt = droid.readString();

        if (!"Input instructions:".equals(prompt)) {
            throw new RuntimeException("Wrong prompt: " + prompt);
        }
    }

    private void sendInstructions(String[] instructions) {
        for (var instruction : instructions) {
            droid.send(instruction + '\n');
        }
    }

    private void expectString(String exp) {
        var str = droid.readString();

        if (!exp.equals(str)) {
            throw new RuntimeException("Expected " + exp + ", found " + str);
        }
    }

    @Override
    public int solve(List<String> lines) {
        var prog = parser.parse(lines);
        var instructions = getInstructionList();
        var speed = getSpeed();

        droid = new Droid(prog);

        readPrompt();
        sendInstructions(instructions);
        droid.send(speed.toUpperCase() + "\n");

        expectString("");
        expectString(getSpeedLabel() + "...");
        expectString("");

        return (int) droid.read();
    }
}
