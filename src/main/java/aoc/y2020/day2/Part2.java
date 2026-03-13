package aoc.y2020.day2;

public class Part2 extends Solver {
    protected boolean validate(DBEntry entry) {
        var policy = entry.policy();
        var low = policy.low();
        var high = policy.high();
        var pw = entry.password();
        var count = 0;

        count += pw.charAt(low - 1) == policy.letter() ? 1 : 0;
        count += pw.charAt(high - 1) == policy.letter() ? 1 : 0;

        return count == 1;
    }
}
