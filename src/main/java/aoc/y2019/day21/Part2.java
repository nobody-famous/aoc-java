package aoc.y2019.day21;

public class Part2 extends Solver {
    public Part2(String fileName, int exp) {
        super(fileName, exp);
    }

    @Override
    protected String[] getInstrList() {
        return new String[] { "NOT A T", "NOT B J", "OR T J", "NOT C T", "OR T J", "NOT E T", "AND H T", "OR E T",
                "AND T J", "AND D J", };
    }

    @Override
    protected String getSpeed() {
        return "Run";
    }

    @Override
    protected String getSpeedLabel() {
        return "Running";
    }
}
