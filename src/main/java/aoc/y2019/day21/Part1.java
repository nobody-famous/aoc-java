package aoc.y2019.day21;

public class Part1 extends Solver {
    public Part1(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected String[] getInstrList() {
        return new String[] { "NOT A J", "NOT B T", "OR T J", "NOT C T", "OR T J", "AND D J", };
    }

    @Override
    protected String getSpeed() {
        return "Walk";
    }

    @Override
    protected String getSpeedLabel() {
        return "Walking";
    }
}
