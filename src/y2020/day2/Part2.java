package y2020.day2;

import java.util.List;

public class Part2 extends Solver {
    public Part2(List<DBEntry> input) {
        super(input);
    }

    protected boolean validate(DBEntry entry) {
        var policy = entry.getPolicy();
        var low = policy.getLow();
        var high = policy.getHigh();
        var pw = entry.getPassword();
        var count = 0;

        count += pw.charAt(low - 1) == policy.getLetter() ? 1 : 0;
        count += pw.charAt(high - 1) == policy.getLetter() ? 1 : 0;

        return count == 1;
    }
}
