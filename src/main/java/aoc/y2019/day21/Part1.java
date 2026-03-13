package aoc.y2019.day21;

public class Part1 extends Solver {
    @Override
    protected String[] getInstructionList() {
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
