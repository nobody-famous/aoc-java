package aoc.y2020.day19;

public class Part2 extends Solver {
    @Override
    protected void updateInput(Notes input) {
        input.rules().set(8, new OrRule(new AndRule(new int[]{ 42 }), new AndRule(new int[]{ 42, 8 })));
        input.rules().set(11, new OrRule(new AndRule(new int[]{ 42, 31 }), new AndRule(new int[]{ 42, 11, 31 })));
    }
}
