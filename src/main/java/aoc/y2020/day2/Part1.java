package aoc.y2020.day2;

import java.util.List;

public class Part1 extends Solver {
    public Part1(List<DBEntry> input, long expected) {
        super(input, expected);
    }

    private int countLetter(char letter, String pw) {
        int count = 0;

        for (var ch : pw.toCharArray()) {
            if (ch == letter) {
                count += 1;
            }
        }

        return count;
    }

    protected boolean validate(DBEntry entry) {
        var policy = entry.policy();
        var count = countLetter(policy.letter(), entry.password());

        return count >= policy.low() && count <= policy.high();
    }
}
