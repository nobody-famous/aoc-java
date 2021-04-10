package y2020.day19;

import utils.Problem;

public class Part1 implements Problem {
    private Notes input;

    public Part1(Notes input) {
        this.input = input;
    }

    public long solve() {
        var ruleZero = input.getRules().get(0);

        System.out.println(ruleZero);

        return 0;
    }
}
