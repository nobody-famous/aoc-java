package y2018.day1;

import java.util.HashSet;

import utils.Problem;

public class Part2 extends Problem<Long> {
    private Parser parser;

    public Part2(String fileName, long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Long run() {
        var ints = parser.parse();
        var seen = new HashSet<Long>();

        var ndx = 0;
        var total = 0L;
        var dup = 0L;

        while (dup == 0) {
            total += ints[ndx];

            if (seen.contains(total)) {
                dup = total;
            } else {
                seen.add(total);
                ndx = (ndx + 1) % ints.length;
            }
        }

        return dup;
    }
}
