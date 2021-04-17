package y2020.day19;

public class Part2 extends Solver {
    public Part2(Notes input, long expected) {
        super(input, expected);
    }

    public void solve() {
        var rules = input.getRules();

        rules.set(8, new OrRule(new AndRule(new int[] { 42 }), new AndRule(new int[] { 42, 8 })));
        rules.set(11, new OrRule(new AndRule(new int[] { 42, 31 }), new AndRule(new int[] { 42, 11, 31 })));

        super.solve();
    }
}
