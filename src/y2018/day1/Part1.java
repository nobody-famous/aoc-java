package y2018.day1;

import utils.Problem;

public class Part1 extends Problem<Long> {
    private Parser parser;

    public Part1(String fileName, Long exp) {
        super(exp);

        parser = new Parser(fileName);
    }

    public Long run() {
        var ints = parser.parse();
        var total = 0L;

        for (var i : ints) {
            total += i;
        }

        return total;
    }
}
