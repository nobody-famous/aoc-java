package aoc.y2019.day21;

import aoc.utils.Problem;
import aoc.y2019.intcode.Parser;

public abstract class Solver extends Problem<Integer> {
    private Parser parser;
    private Droid droid;

    public Solver(String fileName, int exp) {
        super(exp);

        this.parser = new Parser(fileName);
    }

    protected abstract String[] getInstrList();

    protected abstract String getSpeed();

    protected abstract String getSpeedLabel();

    private void readPrompt() {
        var prompt = droid.readString();

        if (!"Input instructions:".equals(prompt)) {
            throw new RuntimeException("Wrong prompt: " + prompt);
        }
    }

    private void sendInstructions(String[] instrs) {
        for (var instr : instrs) {
            droid.send(instr + '\n');
        }
    }

    private void expectString(String exp) {
        var str = droid.readString();

        if (!exp.equals(str)) {
            throw new RuntimeException("Expected " + exp + ", found " + str);
        }
    }

    @Override
    public Integer run() {
        var prog = parser.parse();
        var instrs = getInstrList();
        var speed = getSpeed();

        droid = new Droid(prog);

        readPrompt();
        sendInstructions(instrs);
        droid.send(speed.toUpperCase() + "\n");

        expectString("");
        expectString(getSpeedLabel() + "...");
        expectString("");

        return (int) droid.read();
    }
}
